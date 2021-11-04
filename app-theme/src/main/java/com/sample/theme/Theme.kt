package com.sample.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

val lightThemeColors = lightColors(
    primary = White,
    primaryVariant = Purple700,
    secondary = Teal200,
    secondaryVariant = SecondaryVariant,
    background = White,
    surface = White,
    error = LightError,
    onPrimary = Black,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black,
    onError = LightError
)

val darkThemeColors = darkColors(
    primary = Black,
    primaryVariant = Purple700,
    secondary = Teal200,
    secondaryVariant = Gray,
    background = Black,
    surface = Black,
    error = DarkError,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
    onError = DarkError
)

@Composable
fun MultiComposeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        darkThemeColors
    } else {
        lightThemeColors
    }

    MaterialTheme(
        colors = colors,
        typography = typography(),
        shapes = Shapes,
        content = content
    )
}