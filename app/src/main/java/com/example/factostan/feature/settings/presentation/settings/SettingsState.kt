package com.example.factostan.feature.settings.presentation.settings

import com.example.factostan.feature.settings.domain.Settings

data class SettingsState(
    val settings: Settings = Settings(),
)