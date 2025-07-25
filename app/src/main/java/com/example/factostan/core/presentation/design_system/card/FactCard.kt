package com.example.factostan.core.presentation.design_system.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.factostan.core.presentation.design_system.buttons.PrimaryButton
import com.example.factostan.core.presentation.design_system.theme.Dimens
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.core.presentation.design_system.theme.bgGradient

@Composable
fun FactCard(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )

    ) {
        Column(
            modifier = Modifier
                .padding(Dimens.MEDIUM_PADDING)
        ) {
            content()
        }
    }
}


@Preview
@Composable
private fun FactCard(

) {
    FactostanTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.bgGradient)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            FactCard {
                Text("Hello world")
            }
        }
    }

}