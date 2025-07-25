package com.example.factostan.core.presentation.design_system.bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.factostan.app.navigation.NavigationRoute
import com.example.factostan.app.navigation.toMessage
import com.example.factostan.core.presentation.design_system.buttons.PrimaryIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    onSettingsClick: () -> Unit,
    currentRoute: NavigationRoute,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = currentRoute.toMessage(),
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = MaterialTheme.colorScheme.onSurface
        ),
        actions = {
            PrimaryIconButton(
                imageVector = Icons.Default.Settings,
                onClick = {
                    onSettingsClick()
                }
            )
        }
    )
}