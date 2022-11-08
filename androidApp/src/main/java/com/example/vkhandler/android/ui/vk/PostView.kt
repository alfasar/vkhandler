package com.example.vkhandler.android.ui.vk

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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

    val postList = viewModel.posts.collectAsState(initial = emptyList()).value

    Box(modifier = Modifier.padding(16.dp)) {
        LazyColumn {
            items(
                items = postList,
                key = { it.id }
            ) { post ->
                Text(text = post.text)
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
            }
        }
    }
}
