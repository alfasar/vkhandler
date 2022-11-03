package com.example.vkhandler.android.ui.vk

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.example.vkhandler.android.ui.theme.Fun
import com.example.vkhandler.presentation.PostViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun PostView(
    viewModel: PostViewModel = getViewModel(),
    onUpButtonClick: Fun
) {
    Column {
        Toolbar(onUpButtonClick)
        PostContentView(viewModel = viewModel)
    }
}

@Composable
private fun Toolbar(onUpButtonClick: Fun) {
    TopAppBar(
        title = {
            Text(text = "Post")
        },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(imageVector = Icons.Filled.PhotoCamera, contentDescription = "Posts")
            }
        }
    )
}

@Composable
private fun PostContentView(viewModel: PostViewModel) {


}

