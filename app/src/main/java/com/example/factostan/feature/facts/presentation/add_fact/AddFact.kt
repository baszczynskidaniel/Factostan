package com.example.factostan.feature.facts.presentation.add_fact

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.factostan.R
import com.example.factostan.core.presentation.design_system.buttons.PrimaryButton
import com.example.factostan.core.presentation.design_system.card.FactCard
import com.example.factostan.core.presentation.design_system.text_fields.TransparentHintTextField
import com.example.factostan.core.presentation.design_system.theme.Dimens
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.core.presentation.design_system.theme.bgGradient
import com.example.factostan.core.presentation.util.ObserveAsEvents

@Composable
fun AddFactScreenRoot(
    viewModel: AddFactViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val context = LocalContext.current

    ObserveAsEvents(viewModel.events) { event ->
        when(event) {
            AddFactEvent.OnAddFact -> {
                Toast.makeText(context, context.getString(R.string.fact_added), Toast.LENGTH_SHORT).show()
            }
        }
    }

    AddFactScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun AddFactScreen(
    state: AddFactState,
    onAction: (AddFactAction) -> Unit,
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.MEDIUM_PADDING)
    ) {
        FactCard(
            modifier = Modifier
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Top,
            ) {
                TransparentHintTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .heightIn(min = 64.dp),
                    text = state.text,
                    onValueChange = { onAction(AddFactAction.OnTextChange(it)) },
                    hintText = stringResource(R.string.your_new_fact),
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black
                    )
                )
                AnimatedVisibility(state.text.isNotBlank()) {
                    IconButton(
                        onClick = { onAction(AddFactAction.OnClearText) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = stringResource(R.string.clear_text),
                        )
                    }
                }

            }
        }
        AnimatedVisibility(state.text.isNotBlank()) {
            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.add_fact),
                onClick = { onAction(AddFactAction.OnAddFact) },
            )
        }
    }
}

@Preview
@Composable
private fun AddFactScreenPreview() {
    FactostanTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.bgGradient)
                .padding(Dimens.MEDIUM_PADDING)
        ) {
            AddFactScreen(
                state = AddFactState(
                    text = ""
                ),
                onAction = {}
            )
        }
    }
}