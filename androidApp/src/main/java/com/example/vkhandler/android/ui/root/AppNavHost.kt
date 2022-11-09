package com.example.vkhandler.android.ui.root

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vkhandler.android.ui.vk.PhotoView
import com.example.vkhandler.android.ui.vk.PostView
import com.example.vkhandler.presentation.Screen

@ExperimentalMaterialApi
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.PhotoScreen.route,
        modifier = modifier,
    ) {
        composable(Screen.PhotoScreen.route) {
            PhotoView()
        }
        composable(Screen.PostScreen.route) {
            PostView()
        }
    }
}