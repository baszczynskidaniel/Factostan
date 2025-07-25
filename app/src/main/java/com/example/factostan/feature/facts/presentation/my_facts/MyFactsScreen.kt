package com.example.factostan.feature.facts.presentation.my_facts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.factostan.core.presentation.design_system.theme.Dimens
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.feature.facts.presentation.my_facts.components.FactItem

@Composable
fun MyFactsScreenRoot(
    viewModel: MyFactsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MyFactsScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun MyFactsScreen(
    state: MyFactsState,
    onAction: (MyFactsAction) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(Dimens.MEDIUM_PADDING)
    ) {
        items(state.facts.size, key = { state.facts[it].id }) { index ->
            FactItem(
                factUi = state.facts[index],
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview
@Composable
private fun MyFactsScreenPreview() {
    FactostanTheme {
        MyFactsScreen(
            state = MyFactsState(),
            onAction = {}
        )
    }
}