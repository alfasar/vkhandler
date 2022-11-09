package com.example.vkhandler.android.theme

import androidx.compose.ui.graphics.Color

val primary = Color(0xFF0000FF)
val primaryVariantLight = Color(0xFF9999FF)
val primaryVariantDark = Color(0xFF001A66)

val secondary = Color(0xFF0066FF)
val secondaryVariantLight = Color(0xFF66A3FF)
val secondaryVariantDark = Color(0xFF002966)

private val cardColorSet = listOf(
    Color(0xFFF6EE99),
    Color(0xFF96E39B),
    Color(0xFFDB9EE5),
    Color(0xFFA7DEE4),
    Color(0xFFE8ADC2)
)

fun getCardColor(): Color = cardColorSet.random()
