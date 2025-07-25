package com.example.factostan.feature.settings.presentation.settings

import com.example.factostan.feature.settings.domain.Language

sealed interface SettingsAction {
    data class OnLanguageChange(val language: Language): SettingsAction
}