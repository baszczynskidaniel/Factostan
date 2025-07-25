package com.example.factostan.feature.settings.presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.factostan.R
import com.example.factostan.core.presentation.design_system.card.FactCard
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.feature.settings.domain.Language
import com.example.factostan.feature.settings.presentation.settings.components.LanguageItem

@Composable
fun SettingsScreenRoot(
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SettingsScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SettingsScreen(
    state: SettingsState,
    onAction: (SettingsAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        FactCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.language),
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black
            )
            Language.values().forEach { language ->
                LanguageItem(
                    language = language,
                    modifier = Modifier.fillMaxWidth(),
                    selected = state.settings.language == language,
                    onClick = {
                        onAction(SettingsAction.OnLanguageChange(language))
                    }
                )
            }

        }
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    FactostanTheme {
        SettingsScreen(
            state = SettingsState(),
            onAction = {}
        )
    }
}