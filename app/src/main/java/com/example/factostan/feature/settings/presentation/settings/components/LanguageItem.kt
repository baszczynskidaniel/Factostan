package com.example.factostan.feature.settings.presentation.settings.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.factostan.R
import com.example.factostan.core.presentation.design_system.list_item.AppListItem
import com.example.factostan.core.presentation.design_system.theme.Dimens
import com.example.factostan.feature.settings.domain.Language

@Composable
fun LanguageItem(
    language: Language,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    AppListItem(
        modifier = modifier.clickable {
            if(!selected) {
                onClick()
            }
        },
        leadingContent = {
            Icon(
                modifier = Modifier.size(Dimens.MEDIUM_ICON),
                imageVector = language.getIcon(),
                contentDescription = language.getOriginName(),
                tint = Color.Unspecified
            )

        },
        headlineContent = {
            Text(
                language.getOriginName(),
                color = Color.Black,
                fontWeight = if(selected) FontWeight.Bold else FontWeight.Normal,
            )
        },
        trailingContent = {
            AnimatedVisibility (selected) {
                Icon(

                    Icons.Default.Done,
                    tint = Color.Black,
                    contentDescription = stringResource(R.string.selected_language, language.getOriginName()),
                )
            }
        }
    )
}