package com.example.factostan.app.main_activity

import com.example.factostan.feature.settings.domain.Settings

data class MainActivityState(
    val settings: Settings = Settings(),
    val isLoading: Boolean = true,
)
