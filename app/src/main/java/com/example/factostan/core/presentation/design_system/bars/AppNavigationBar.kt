package com.example.factostan.core.presentation.design_system.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.factostan.app.navigation.NavigationRoute
import com.example.factostan.app.navigation.toMessage
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.core.presentation.design_system.theme.Quote
import com.example.factostan.core.presentation.design_system.theme.Save
import com.example.factostan.core.presentation.design_system.theme.WhiteShadow
import com.example.factostan.core.presentation.design_system.theme.bgGradient

data class NavigationItem(
    val route: NavigationRoute,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@Composable
fun AppNavigationBar(
    onNavigationClick: (NavigationRoute) -> Unit,
    currentRoute: NavigationRoute,
    modifier: Modifier = Modifier
) {
    val navigationBarItemColors = NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.onSurface,
        selectedTextColor = MaterialTheme.colorScheme.onSurface,
        indicatorColor = MaterialTheme.colorScheme.WhiteShadow,
    )

    val navigationItems: List<NavigationItem> = listOf<NavigationItem>(
        NavigationItem(
            route = NavigationRoute.Facts, 
            selectedIcon = Icons.Filled.Quote,
            unselectedIcon = Icons.Outlined.Quote,
        ),
        NavigationItem(
            route = NavigationRoute.AddFact,
            selectedIcon = Icons.Filled.AddCircle,
            unselectedIcon = Icons.Outlined.AddCircle,
        ),
        NavigationItem(
            route = NavigationRoute.MyFacts,
            selectedIcon = Icons.Filled.Save,
            unselectedIcon = Icons.Outlined.Save,
        )
    )


    NavigationBar(
        containerColor = Color.Transparent,
        modifier = modifier
           // .background(MaterialTheme.colorScheme.BlackToTransparentGradient),
    ) {
        navigationItems.forEach { item ->

            NavigationBarItem(
                colors = navigationBarItemColors,
                selected = item.route == currentRoute,
                onClick = { onNavigationClick(item.route) },
                icon = {
                    Icon(
                        imageVector = if (item.route == currentRoute) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.route.toMessage(),
                    )
                },
                label = {
                    Text(
                        text = item.route.toMessage(),
                        fontWeight = if (item.route == currentRoute) FontWeight.Bold else FontWeight.Normal
                    )
                }
            )
        }
    }
}

@Preview
@Composable
private fun AppNavigationBarPreview() {
    FactostanTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.bgGradient),
            contentAlignment = Alignment.BottomCenter
        ) {
            AppNavigationBar(
                onNavigationClick = {},
                currentRoute = NavigationRoute.MyFacts
            )
        }
    }
}