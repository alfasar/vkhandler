package com.example.vkhandler.android.theme

import androidx.compose.ui.graphics.Color

val primaryColor = Color(0xFF3D5AFE)
val primaryLightColor = Color(0xFF00B0FF)
val primaryDarkColor = Color(0xFF050E41)
val secondaryColor = Color(0xFF00B0FF)
val secondaryLightColor = Color(0xFF3EE0F3)
val secondaryDarkColor = Color(0xFF02061F)

private val randomColors = listOf(
    Color(0xFFF6EE99),
    Color(0xFFABE878),
    Color(0xFFE290F0),
    Color(0xFFA7DEE4),
    Color(0xFFFB669B),
    Color(0xFFED9EAD)
)

fun getCardColor(): Color = randomColors.random()