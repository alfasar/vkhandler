package com.example.vkhandler.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(
    isSystemInDarkTheme: Boolean = isSystemInDarkTheme(),
    content: ComposeFun
) {

    val colors = if (isSystemInDarkTheme) {
        darkColors().copy(
            primary = primary,
            primaryVariant = primaryVariantDark,
            secondary = secondary,
            secondaryVariant = secondaryVariantDark
        )
    } else {
        lightColors().copy(
            primary = primary,
            primaryVariant = primaryVariantLight,
            secondary = secondary,
            secondaryVariant = secondaryVariantLight
        )
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}
