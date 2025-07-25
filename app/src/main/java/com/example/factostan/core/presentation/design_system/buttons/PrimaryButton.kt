package com.example.factostan.core.presentation.design_system.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.factostan.core.presentation.design_system.theme.FactostanTheme
import com.example.factostan.core.presentation.design_system.theme.WhiteShadow
import com.example.factostan.core.presentation.design_system.theme.bgGradient

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    //leadingIcon: @Composable (() -> Unit)? = null
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.WhiteShadow,
            contentColor = Color.White
        )
    ) {
        Text(
            text = text
        )
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    FactostanTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.bgGradient)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            PrimaryButton(text = "Button", onClick = {})
        }
    }
}