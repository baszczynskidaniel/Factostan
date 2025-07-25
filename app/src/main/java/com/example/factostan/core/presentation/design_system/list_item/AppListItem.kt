package com.example.factostan.core.presentation.design_system.list_item

import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AppListItem(
    headlineContent: @Composable (() -> Unit),
    modifier: Modifier = Modifier,
    overlineContent: @Composable (() -> Unit)? = null,
    supportingContent: @Composable (() -> Unit)? = null,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
) {
    ListItem(
        modifier = modifier,
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent
        ),
        leadingContent = {
            leadingContent
        },
        headlineContent = {
            headlineContent
        },
        trailingContent = {
            trailingContent
        },
        overlineContent = {
            overlineContent
        },
        supportingContent = {
            supportingContent
        }
    )
}