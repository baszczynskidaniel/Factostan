package com.example.factostan.app.main_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.factostan.feature.settings.domain.SettingsPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val dataStoreSettings: SettingsPreferences
): ViewModel() {
    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(MainActivityState(
    ))

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
            initialValue = MainActivityState()
        )

    private fun observeSettings() {
        dataStoreSettings
            .observeSettings()
            .onEach { settings ->
                _state.update { it.copy(
                    settings = settings,
                    isLoading = false
                ) }
            }
            .launchIn(viewModelScope)
    }
}