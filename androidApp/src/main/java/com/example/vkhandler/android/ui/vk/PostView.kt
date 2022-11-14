package com.example.vkhandler.android.ui.vk

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.vkhandler.android.R
import com.example.vkhandler.android.theme.getCardColor
import com.example.vkhandler.android.utils.Constants.EMPTY_STRING
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

    val postList = viewModel.posts.collectAsState(initial = emptyList())

    val postToDelete = remember {
        mutableStateOf(EMPTY_STRING)
    }

    val postToEdit = remember {
        mutableStateOf(EMPTY_STRING)
    }

    Box(modifier = Modifier.padding(16.dp)) {
        LazyColumn {
            items(
                items = postList.value,
                key = { it.id }
            ) { post ->
                Card(
                    backgroundColor = getCardColor(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clipToBounds(),
                    onClick = {
                        postToEdit.value = post.id.toString()
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
                                postToDelete.value = post.id.toString()
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

        if (postToDelete.value.isNotEmpty()) {
            fun dismiss() {
                postToDelete.value = EMPTY_STRING
            }
            AlertDialog(
                onDismissRequest = { postToDelete.value = EMPTY_STRING },
                title = {
                    Text(
                        text = stringResource(id = R.string.delete_post),
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                    )
                },
                confirmButton = {
                    Button(
                        onClick = {
                            viewModel.deletePost(postToDelete.value)
                            dismiss()
                        },
                        modifier = Modifier.padding(horizontal = 5.dp)
                    ) { Text(text = stringResource(id = R.string.yes_button), color = Color.White) }
                },
                dismissButton = {
                    Button(
                        onClick = { dismiss() }
                    ) { Text(text = stringResource(id = R.string.no_button), color = Color.White) }
                },
                shape = RoundedCornerShape(CornerSize(15.dp)),
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        if (postToEdit.value.isNotEmpty()) {
            SendPostDialog(
                viewModel = viewModel,
                postId = postToEdit.value,
                onDismiss = { postToEdit.value = EMPTY_STRING }
            )
        }
    }
}
