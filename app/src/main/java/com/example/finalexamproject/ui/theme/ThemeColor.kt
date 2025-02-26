package com.example.finalexam.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF00A67E),
    onPrimary = Color.White,
    secondary = Color(0xFFFF9B50),
    background = Color.White,
    surface = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF00A67E),
    onPrimary = Color.White,
    secondary = Color(0xFFFF9B50),
    background = Color(0xFF121212),
    surface = Color(0xFF2D3439),
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun OrderAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}