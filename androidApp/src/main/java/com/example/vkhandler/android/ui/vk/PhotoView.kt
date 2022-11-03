package com.example.vkhandler.android.ui.vk

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.runtime.Composable
import com.example.vkhandler.android.ui.theme.Fun
import com.example.vkhandler.presentation.PhotoViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun PhotoView(
    viewModel: PhotoViewModel = getViewModel(),
    onPostClickButton: Fun
) {
    Column {
        Toolbar(onPostClickButton)
        PhotoContentView(viewModel)
    }

}

@Composable
private fun Toolbar(onUpButtonClick: Fun) {
    TopAppBar(
        title = {
            Text(text = "Photo")
        },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(imageVector = Icons.Filled.PhotoCamera, contentDescription = "Photos")
            }
        }
    )
}

@Composable
private fun PhotoContentView(
    viewModel: PhotoViewModel
) {
    Box {
        LazyColumn {
        }
    }
}