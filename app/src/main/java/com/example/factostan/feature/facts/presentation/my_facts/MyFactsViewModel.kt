package com.example.factostan.feature.facts.presentation.my_facts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.factostan.feature.facts.domain.FactRepository
import com.example.factostan.feature.facts.presentation.mappers.toFactUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyFactsViewModel @Inject constructor(
    private val factRepository: FactRepository,
): ViewModel() {

    

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(MyFactsState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                fetchFacts()
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = MyFactsState()
        )

    private fun fetchFacts() {
        viewModelScope.launch {
            val facts = factRepository.getFactsFromDb().first().map { fact -> fact.toFactUi() }
            _state.update { it.copy(facts = facts) }

        }
    }

    fun onAction(action: MyFactsAction) {
        when (action) {
            else -> {}
        }
    }
}