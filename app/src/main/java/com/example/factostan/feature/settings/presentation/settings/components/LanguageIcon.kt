package com.example.factostan.feature.settings.presentation.settings.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.factostan.R
import com.example.factostan.feature.settings.domain.Language

@Composable
fun Language.getIcon(): ImageVector {
    return when(this) {
        Language.ENGLISH -> ImageVector.vectorResource(R.drawable.united_kingdom_flag)
        Language.POLISH ->ImageVector.vectorResource(R.drawable.poland_flag)

    }
}