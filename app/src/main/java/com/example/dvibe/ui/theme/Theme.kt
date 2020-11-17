package com.example.dvibe.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = purple,
    primaryVariant = purple200,
    onPrimary = Color.White,
    secondary = coral,
    onSecondary = Color.White,
    onSurface = charcoalGrey.copy(alpha = 0.8f),
    background = lightGrey200,
    onBackground = charcoalGrey
)

private val DarkColorPalette = darkColors(
    primary = purple,
    primaryVariant = purple200,
    onPrimary = Color.White,
    secondary = coral,
    onSecondary = Color.White,
    onSurface = Color.White,
    background = charcoalGrey,
    onBackground = lightGrey200
)

@Composable
fun DVibeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = DVibeTypography,
        shapes = shapes,
        content = content
    )
}

/**
 *
 **/