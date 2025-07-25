package com.example.factostan.core.presentation.design_system.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.factostan.app.AppState
import com.example.factostan.app.navigation.NavigationRoot
import com.example.factostan.app.navigation.NavigationRoute
import com.example.factostan.core.presentation.design_system.bars.AppNavigationBar
import com.example.factostan.core.presentation.design_system.bars.AppTopBar
import com.example.factostan.core.presentation.design_system.theme.Dimens
import com.example.factostan.core.presentation.design_system.theme.bgGradient

@Composable
fun AppScaffold(
    appState: AppState,
) {
    Scaffold(
        topBar = {
            AppTopBar(
                onSettingsClick = {
                    appState.navController.navigate(NavigationRoute.Settings)
                },
                currentRoute = appState.currentNavigationRoute,
            )
        },
        bottomBar = {
            AppNavigationBar(
                onNavigationClick = {
                    appState.navController.navigate(it)
                },
                currentRoute = appState.currentNavigationRoute,
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = MaterialTheme.colorScheme.bgGradient)
                .padding(innerPadding)
                .padding(Dimens.MEDIUM_PADDING)
        ) {
            NavigationRoot(navController = appState.navController)
        }
    }
}
