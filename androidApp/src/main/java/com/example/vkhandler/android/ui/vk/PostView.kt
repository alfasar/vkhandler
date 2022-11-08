package com.example.vkhandler.android.ui.vk

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vkhandler.presentation.PostViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun PostView(
    viewModel: PostViewModel = getViewModel(),
) {
    Column {
        PostContentView(viewModel = viewModel)
    }
}

@Composable
private fun PostContentView(viewModel: PostViewModel) {

    Box(modifier = Modifier.padding(16.dp)) {
        LazyColumn {
            items(
                items = postsMockList,
                key = { it }
            ) { post ->
                Text(text = post)
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
            }
        }
    }
}

private val postsMockList = listOf(
    "Post 1", "Post 2", "Post 3", "Post 4", "Post 5",
    "Post 6", "Post 7", "Post 8", "Post 9", "Post 10",
    "Post 11", "Post 12", "Post 13", "Post 14", "Post 15",
    "Post 16", "Post 17", "Post 18", "Post 19", "Post 20"
)

