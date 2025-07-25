package com.example.factostan.feature.settings.data

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.factostan.feature.settings.domain.Settings
import com.example.factostan.feature.settings.domain.SettingsPreferences
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.preferencesDataStore
import com.example.factostan.feature.settings.domain.Language
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

val Context.settingsDataStore by preferencesDataStore(name = "settings_datastore")

@Singleton
class DataStoreSettings @Inject constructor(
    @ApplicationContext private val context: Context
) : SettingsPreferences {

    companion object {
        private val languageKey = stringPreferencesKey("language")
    }

    override fun observeSettings(): Flow<Settings> {
        return context.settingsDataStore.data.map { prefs ->
            Settings(
                language = Language.fromString(prefs[languageKey] ?: "en") ?: Language.ENGLISH
            )
        }
    }

    override suspend fun setSettings(settings: Settings) {
        context.settingsDataStore.edit { prefs ->
            prefs[languageKey] = settings.language.isoFormat
        }
    }

    override suspend fun setLanguage(language: Language) {
        context.settingsDataStore.edit { prefs ->
            prefs[languageKey] = language.isoFormat
        }
        val locale = Locale(language.isoFormat)
        Locale.setDefault(locale)

        val config = context.resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)

        AppCompatDelegate.setApplicationLocales(
            LocaleListCompat.create(
                Locale(locale.language, locale.country)
            )
        )


        Log.d("Locale", context.resources.configuration.locales[0].toLanguageTag())
    }
}
