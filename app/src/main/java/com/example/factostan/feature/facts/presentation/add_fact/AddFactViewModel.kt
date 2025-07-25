package com.example.factostan.feature.facts.presentation.add_fact

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.factostan.feature.facts.domain.Fact
import com.example.factostan.feature.facts.domain.FactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFactViewModel @Inject constructor(
    private val factRepository: FactRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val eventChannel = Channel<AddFactEvent>()
    val events = eventChannel.receiveAsFlow()

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(AddFactState(
        text = savedStateHandle.get<String>("text") ?: ""
    ))
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .onEach { state ->
            savedStateHandle["text"] = state.text
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = AddFactState()
        )

    fun onAction(action: AddFactAction) {
        when (action) {
            AddFactAction.OnAddFact -> onAddFact()
            AddFactAction.OnClearText -> _state.update { it.copy(text = "") }
            is AddFactAction.OnTextChange -> _state.update { it.copy(text = action.text) }
        }
    }

    private fun onAddFact() {
        viewModelScope.launch {
            factRepository.insertFact(
                Fact(
                    text = state.value.text,
                    source = "User",
                    id = "",
                )
            )
        }
        _state.update {
            it.copy(text = "")
        }
        eventChannel.trySend(AddFactEvent.OnAddFact)
    }
}