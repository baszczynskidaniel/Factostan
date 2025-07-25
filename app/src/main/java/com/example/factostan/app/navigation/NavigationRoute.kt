package com.example.factostan.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.factostan.R
import com.example.factostan.app.navigation.NavigationRoute.AddFact
import com.example.factostan.app.navigation.NavigationRoute.Facts
import com.example.factostan.app.navigation.NavigationRoute.MyFacts
import com.example.factostan.app.navigation.NavigationRoute.Settings
import kotlinx.serialization.Serializable

sealed interface NavigationRoute {
    @Serializable
    data object Facts : NavigationRoute

    @Serializable
    data object Settings : NavigationRoute

    @Serializable
    data object AddFact : NavigationRoute

    @Serializable
    data object MyFacts : NavigationRoute

    companion object {
        fun fromRoute(route: String?): NavigationRoute {
            return when (route) {
                Facts::class.qualifiedName -> Facts
                Settings::class.qualifiedName -> Settings
                AddFact::class.qualifiedName -> AddFact
                MyFacts::class.qualifiedName -> MyFacts
                else -> Facts
            }
        }
    }
}

@Composable
fun NavigationRoute.toMessage(): String {
    return when (this) {
        Facts -> stringResource(R.string.random_facts)
        Settings -> stringResource(R.string.settings)
        AddFact -> stringResource(R.string.add_fact)
        MyFacts -> stringResource(R.string.my_facts)
    }
}

