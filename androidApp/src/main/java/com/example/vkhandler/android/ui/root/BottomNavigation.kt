package com.example.vkhandler.android.ui.root

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
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

    val selectedItem = remember { mutableStateOf(0) }

    BottomNavigation {

        bottomNavigationItems.forEachIndexed { index, item ->

            BottomNavigationItem(
                selected = selectedItem.value == index,
                onClick = {
                    when (selectedItem.value) {
                        0 -> navController.navigate(item.route)
                        else -> navController.navigateUp()
                    }
                    selectedItem.value = index
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
