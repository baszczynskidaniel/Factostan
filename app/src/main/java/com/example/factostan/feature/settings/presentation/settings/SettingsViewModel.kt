package com.example.factostan.feature.settings.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.factostan.feature.settings.domain.Language
import com.example.factostan.feature.settings.domain.SettingsPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsRepository: SettingsPreferences
) : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(SettingsState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                observeSettings()
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = SettingsState()
        )

    fun onAction(action: SettingsAction) {
        when (action) {
            is SettingsAction.OnLanguageChange -> onLanguageChange(action.language)
        }
    }

    private fun onLanguageChange(language: Language) {
        viewModelScope.launch {
            settingsRepository.setLanguage(language)

        }

    }

    private fun observeSettings() {

        settingsRepository
            .observeSettings()
            .onEach { settings ->
                _state.update {
                it.copy(
                    settings = settings
                )
            } }

            .launchIn(viewModelScope)

    }

}