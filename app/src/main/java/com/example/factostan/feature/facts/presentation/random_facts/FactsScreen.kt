package com.example.factostan.feature.facts.presentation.random_facts

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.factostan.R
import com.example.factostan.core.presentation.design_system.buttons.PrimaryIconButton
import com.example.factostan.core.presentation.design_system.spacers.MediumVerticalSpacer
import com.example.factostan.core.presentation.design_system.spacers.SmallVerticalSpacer
import com.example.factostan.core.presentation.design_system.theme.Autorenew
import com.example.factostan.core.presentation.design_system.theme.Copy
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.core.presentation.design_system.theme.Save
import com.example.factostan.core.presentation.util.ObserveAsEvents
import com.example.factostan.feature.facts.presentation.random_facts.components.QuoteCard

@Composable
fun FactsScreenRoot(
    viewModel: FactsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val context = LocalContext.current


    ObserveAsEvents(viewModel.events) { event ->
        when(event) {
            FactsEvent.CopyToClipboard -> {
                val clipboardManager = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val clipData: ClipData = ClipData.newPlainText("text", state.fact.text)
                clipboardManager.setPrimaryClip(clipData)
                Toast.makeText(context, context.getString(R.string.copied_to_clipboard), Toast.LENGTH_SHORT).show()

            }
        }
    }

    FactsScreen(
        state = state,
        onAction = viewModel::onAction
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactsScreen(
    state: FactsState,
    onAction: (FactsAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        QuoteCard(
            text = state.fact.text,
            modifier = Modifier
                .fillMaxWidth()
        )
        MediumVerticalSpacer()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,


        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PrimaryIconButton(

                    imageVector = Icons.Filled.Autorenew,
                    onClick = {
                        onAction(FactsAction.OnNextFact)
                    },
                )
                SmallVerticalSpacer()
                Text(
                    text = stringResource(R.string.next_fact),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelLarge
                )

            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PrimaryIconButton(
                    imageVector = if (state.fact.isSaved) Icons.Filled.Save else Icons.Outlined.Save,
                    onClick = {
                        onAction(FactsAction.OnSaveChange(state.fact.id))
                    },
                    contentDescription = if (state.fact.isSaved) stringResource(R.string.do_not_safe) else stringResource(
                        R.string.save
                    )
                )
                SmallVerticalSpacer()
                Text(
                    text = if (state.fact.isSaved) stringResource(R.string.do_not_safe) else stringResource(
                        R.string.save),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelLarge
                )
            }

            CopyToClipboardIconButton(
                onClick = { onAction(FactsAction.OnCopy) },
                isCopied = state.isCopiedToClipboard,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun CopyToClipboardIconButton(
    onClick: () -> Unit,
    isCopied: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PrimaryIconButton(
            imageVector = if(isCopied) Icons.Filled.Copy else Icons.Outlined.Copy,
            onClick = onClick,
            contentDescription = stringResource(R.string.copy)
        )
        SmallVerticalSpacer()
        Text(
            text = stringResource(R.string.copy),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview
@Composable
private fun FactsScreenPreview() {
    FactostanTheme {
        FactsScreen(
            state = FactsState(),
            onAction = {}
        )
    }
}