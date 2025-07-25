package com.example.factostan.feature.facts.presentation.random_facts.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.factostan.core.presentation.design_system.card.FactCard
import com.example.factostan.core.presentation.design_system.theme.BlackShadow
import com.example.factostan.core.presentation.design_system.theme.Dimens
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.core.presentation.design_system.theme.Quote
import com.example.factostan.core.presentation.design_system.theme.bgGradient

@Composable
fun QuoteCard(
    text: String,
    modifier: Modifier = Modifier
) {
    FactCard(
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.Quote,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.BlackShadow
        )
        Spacer(modifier = Modifier.height(Dimens.MEDIUM_PADDING))
        Text(
            text = text,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Preview
@Composable
private fun PrimaryQuoteCardPreview() {
    FactostanTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.bgGradient)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            QuoteCard(
                modifier = Modifier.fillMaxWidth(),
                text = "This is a random interesting fact"
            )
        }
    }
}