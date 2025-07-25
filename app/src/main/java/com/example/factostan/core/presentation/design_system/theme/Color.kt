package com.example.factostan.core.presentation.design_system.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val ColorScheme.bgGradient: Brush
    get() = Brush.verticalGradient(
        listOf(
            Color(0xff00bf87),
            Color(0xFF004F37),
            Color(0xFF000000),

        )
    )

val ColorScheme.WhiteShadow: Color
    get() = Color.White.copy(alpha = 0.35f)

val ColorScheme.BlackShadow: Color
    get() = Color.Black.copy(alpha = 0.15f)

