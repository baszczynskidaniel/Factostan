package com.example.factostan.feature.facts.presentation.random_facts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.factostan.core.domain.onError
import com.example.factostan.core.domain.onSuccess
import com.example.factostan.feature.facts.domain.Fact
import com.example.factostan.feature.facts.domain.FactRepository
import com.example.factostan.feature.facts.presentation.models.FactUi

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactsViewModel @Inject constructor(
    private val factRepository: FactRepository
): ViewModel() {
    private val eventChannel = Channel<FactsEvent>()
    val events = eventChannel.receiveAsFlow()

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(FactsState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                fetchFact()

                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = FactsState()
        )



    fun onAction(action: FactsAction) {
        when (action) {
            FactsAction.OnCopy -> onCopyToClipboard()
            FactsAction.OnNextFact -> fetchFact()
            is FactsAction.OnSaveChange -> onSaveChange()
        }
    }

    private fun onSaveChange() {
        viewModelScope.launch {
            if(_state.value.fact.isSaved) {
                factRepository.removeFactById(state.value.fact.id)
            } else {
                factRepository.insertFact(
                    Fact(
                        text = state.value.fact.text,
                        source = "API",
                        id = state.value.fact.id,
                    )
                )
            }
            _state.update { it.copy(
                fact = it.fact.copy(isSaved = !_state.value.fact.isSaved)
            ) }
        }
    }

    private fun onCopyToClipboard() {
        viewModelScope.launch {
            eventChannel.send(FactsEvent.CopyToClipboard)
            _state.update { it.copy(
                isCopiedToClipboard = true
            ) }
        }
    }

    private fun fetchFact() {
        viewModelScope.launch {
            factRepository
                .getFacts()
                .onSuccess { fact ->
                    val isSaved = factRepository.getFactByIdFromDb(fact.id).first()
                    _state.update { it.copy(
                        fact = FactUi(fact.text, fact.id, isSaved = isSaved != null),
                        isCopiedToClipboard = false,
                    ) }
                }.onError { error ->
                    _state.update { it.copy(
                        fact = FactUi(error.toString(), "", false),
                        isCopiedToClipboard = false,
                    ) }
                }
        }
    }
}