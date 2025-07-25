package com.example.factostan.feature.settings.domain

import kotlinx.coroutines.flow.Flow


interface SettingsPreferences {
    fun observeSettings(): Flow<Settings>
    suspend fun setSettings(settings: Settings)
    suspend fun setLanguage(language: Language)
}