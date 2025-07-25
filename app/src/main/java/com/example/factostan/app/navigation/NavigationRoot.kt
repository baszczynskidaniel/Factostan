package com.example.factostan.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.factostan.feature.facts.presentation.add_fact.AddFactScreenRoot
import com.example.factostan.feature.facts.presentation.my_facts.MyFactsScreenRoot
import com.example.factostan.feature.facts.presentation.random_facts.FactsScreenRoot
import com.example.factostan.feature.settings.presentation.settings.SettingsScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.Facts
    ) {

        composable<NavigationRoute.Facts> {
            FactsScreenRoot()
        }

        composable<NavigationRoute.Settings> {
            SettingsScreenRoot()
        }

        composable<NavigationRoute.MyFacts> {
            MyFactsScreenRoot()
        }

        composable<NavigationRoute.AddFact> {
            AddFactScreenRoot()
        }
    }
}