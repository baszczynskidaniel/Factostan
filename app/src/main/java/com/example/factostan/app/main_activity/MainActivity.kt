package com.example.factostan.app.main_activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.factostan.app.navigation.NavigationRoot
import com.example.factostan.app.navigation.NavigationRoute
import com.example.factostan.app.rememberAppState
import com.example.factostan.core.presentation.design_system.bars.AppNavigationBar
import com.example.factostan.core.presentation.design_system.bars.AppTopBar
import com.example.factostan.core.presentation.design_system.scaffold.AppScaffold
import com.example.factostan.core.presentation.design_system.theme.Dimens
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.core.presentation.design_system.theme.bgGradient
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContent {
            val themeState = viewModel.state.collectAsState().value
            val appState = rememberAppState()

            FactostanTheme(

            ) {
                AppScaffold(appState)
            }
        }
    }
}