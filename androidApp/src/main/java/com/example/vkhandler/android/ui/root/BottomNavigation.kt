package com.example.vkhandler.android.ui.root

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.vkhandler.presentation.Screen

data class BottomNavigationItem(
    val icon: ImageVector,
    val route: String,
    val contentDescription: String
)

val bottomNavigationItems = listOf(

    BottomNavigationItem(
        icon = Icons.Filled.PhotoCamera,
        route = Screen.PhotoScreen.route,
        contentDescription = "Photos"
    ),
    BottomNavigationItem(
        icon = Icons.Filled.Textsms,
        route = Screen.PostScreen.route,
        contentDescription = "Posts"
    )
)

@Composable
fun BottomNavigationBar(navController: NavController) {

    val route by navController.currentBackStackEntryAsState()

    BottomNavigation {

        bottomNavigationItems.forEach { item ->

            BottomNavigationItem(
                selected = item.route == route?.destination?.route ,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                onClick = {
                    if (item.route != route?.destination?.route) {
                        navController.navigate(item.route)
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.contentDescription
                    )
                }
            )
        }
    }
}
