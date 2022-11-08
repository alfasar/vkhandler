package com.example.vkhandler.android.ui.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vkhandler.android.ui.vk.SendPostDialog
import com.example.vkhandler.presentation.Screen

@Composable
fun AppScaffold() {

    val navController = rememberNavController()

    val currentScreenRoute by navController.currentBackStackEntryAsState()

    val shouldShowDialog = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = { TopAppBar {
            Text(
                text = currentScreenRoute?.destination?.route ?: "VkHandler",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 15.dp)
            )
        } },
        floatingActionButton = {
            when (currentScreenRoute?.destination?.route) {
                Screen.PhotoScreen.route -> {}
                else -> {
                    FloatingActionButton(
                        onClick = {
                            shouldShowDialog.value = true
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null
                        )
                    }
                }
            }
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
        if (shouldShowDialog.value) {
            SendPostDialog(
                onDismiss = { shouldShowDialog.value = false }
            )
        }
    }
}