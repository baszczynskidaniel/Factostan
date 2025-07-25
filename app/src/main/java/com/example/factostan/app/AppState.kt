package com.example.factostan.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.factostan.app.navigation.NavigationRoute
import com.example.factostan.app.navigation.NavigationRoute.Companion.fromRoute


@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
): AppState {
    return remember(
        navController
    ) {
        AppState(
            navController = navController
        )
    }
}

@Stable
class AppState(
    val navController: NavHostController,
) {
    val currentNavigationRoute: NavigationRoute
        @Composable get() {
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)
            val currentRoute = currentEntry.value?.destination?.route
            return fromRoute(currentRoute)
        }
}