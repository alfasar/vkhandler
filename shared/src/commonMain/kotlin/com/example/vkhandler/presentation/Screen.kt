package com.example.vkhandler.presentation

sealed class Screen(val route: String) {
    object PhotoScreen : Screen("Photo")
    object PostScreen : Screen("Post")
}
