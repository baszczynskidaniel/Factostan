package com.example.factostan.core.presentation.design_system.spacers

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.factostan.core.presentation.design_system.theme.Dimens

@Composable
fun SmallVerticalSpacer() = Spacer(modifier = Modifier.height(Dimens.SMALL_PADDING))

@Composable
fun MediumVerticalSpacer() = Spacer(modifier = Modifier.height(Dimens.MEDIUM_PADDING))

@Composable
fun LargeVerticalSpacer() = Spacer(modifier = Modifier.height(Dimens.LARGE_PADDING))


@Composable
fun SmallHorizontalSpacer() = Spacer(modifier = Modifier.width(Dimens.SMALL_PADDING))

@Composable
fun MediumHorizontalSpacer() = Spacer(modifier = Modifier.width(Dimens.MEDIUM_PADDING))

@Composable
fun LargeHorizontalSpacer() = Spacer(modifier = Modifier.width(Dimens.LARGE_PADDING))