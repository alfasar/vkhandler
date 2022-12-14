package com.example.vkhandler.android.ui.vk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.vkhandler.android.R
import com.example.vkhandler.android.theme.Fun
import com.example.vkhandler.android.utils.Constants.EMPTY_STRING
import com.example.vkhandler.presentation.PostViewModel
import org.koin.androidx.compose.getViewModel

private const val MAX_LINES = 6

@Composable
fun SendPostDialog(
    viewModel: PostViewModel = getViewModel(),
    postId: Int? = null,
    onDismiss: Fun
) = Dialog(onDismissRequest = onDismiss) {

    val dialogTitle: String
    val buttonTitle: String
    when (postId == null) {
        true -> {
            dialogTitle = stringResource(id = R.string.write_post_title)
            buttonTitle = stringResource(id = R.string.send_post)
        }
        else -> {
            dialogTitle = stringResource(id = R.string.edit_post_title)
            buttonTitle = stringResource(id = R.string.edit_post_confirm)        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(20.dp)
            .background(Color.Gray)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            val textFieldValue = remember { mutableStateOf(EMPTY_STRING) }

            Text(
                text = dialogTitle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.padding(vertical = 5.dp))

            OutlinedTextField(
                value = textFieldValue.value,
                onValueChange = { input ->
                    textFieldValue.value = input
                },
                maxLines = MAX_LINES,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.padding(vertical = 5.dp))

            Button(
                onClick = {
                    if (textFieldValue.value.isNotEmpty()) {
                        when (postId == null) {
                            true -> viewModel.makePost(textFieldValue.value)
                            else -> viewModel.editPost(postId, textFieldValue.value)
                        }
                        textFieldValue.value = EMPTY_STRING
                    }
                    onDismiss.invoke()
                },
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(
                    text = buttonTitle,
                    color = Color.White
                )
            }
        }
    }
}
