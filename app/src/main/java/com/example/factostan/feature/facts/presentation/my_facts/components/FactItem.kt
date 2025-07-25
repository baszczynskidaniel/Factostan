package com.example.factostan.feature.facts.presentation.my_facts.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.core.presentation.design_system.theme.Quote
import com.example.factostan.core.presentation.design_system.theme.bgGradient
import com.example.factostan.feature.facts.presentation.models.FactUi

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FactItem(
    factUi: FactUi,
    modifier: Modifier = Modifier,


    ) {
    FactCard(
        modifier = modifier


    ) {

        Icon(
            imageVector = Icons.Filled.Quote,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.BlackShadow
        )

        Text(
            text = factUi.text,
            style = MaterialTheme.typography.bodyLarge,
        )

    }
}

@Preview
@Composable
private fun FactItemPreview() {
    FactostanTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.bgGradient)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            FactItem(

                modifier = Modifier.fillMaxWidth(),
                factUi = FactUi(
                    text = "This is a random interesting fact",
                    id = "",
                    isSaved = false,
                )
            )
        }
    }
}
