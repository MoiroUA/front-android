package io.moiro.vision.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = DarkGreen,
    background = Pistachio,
    onPrimary = White,
    onBackground = Black,
    secondary = Grey
)

private val DarkColorPalette = darkColors(
    primary = DarkGreen,
    background = Pistachio,
    onPrimary = White,
    onBackground = Black,
    secondary = Grey
)

@Composable
fun VisionTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}