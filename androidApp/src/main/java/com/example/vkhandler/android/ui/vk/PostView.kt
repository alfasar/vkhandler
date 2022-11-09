package com.example.vkhandler.android.ui.vk

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.vkhandler.android.theme.getCardColor
import com.example.vkhandler.presentation.PostViewModel
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterialApi
@Composable
fun PostView(
    viewModel: PostViewModel = getViewModel(),
) {
    Column {
        PostContentView(viewModel = viewModel)
    }
}

@ExperimentalMaterialApi
@Composable
private fun PostContentView(viewModel: PostViewModel) {

    val postList = viewModel.posts.collectAsState(initial = emptyList()).value

    Box(modifier = Modifier.padding(16.dp)) {
        LazyColumn {
            items(
                items = postList,
                key = { it.id }
            ) { post ->
                Card(
                    backgroundColor = getCardColor(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clipToBounds(),
                    onClick = {
                        // TODO: Process post edit
                    }
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                    ) {
                        Text(
                            text = post.text,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.DarkGray,
                            modifier = Modifier
                                .padding(15.dp)
                                .weight(1f)
                        )
                        IconButton(
                            onClick = {
                                viewModel.deletePost(post.id.toString())
                            },
                            modifier = Modifier
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = "Delete Icon",
                                tint = Color.DarkGray
                            )
                        }
                    }
                }
            }
        }
    }
}
