package com.example.factostan.core.presentation.design_system.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.core.presentation.design_system.theme.WhiteShadow
import com.example.factostan.core.presentation.design_system.theme.bgGradient

@Composable
fun PrimaryIconButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    contentDescription: String? = null,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.WhiteShadow,
        )

    ) {
        Icon(

            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = MaterialTheme.colorScheme.onSurface
        )
        
    }
    
}

@Preview
@Composable
private fun PrimaryIconButtonPreview() {
    FactostanTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.bgGradient)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            PrimaryIconButton(
                imageVector = Icons.Default.Settings,
                onClick = {}
            )
        }
    }
}