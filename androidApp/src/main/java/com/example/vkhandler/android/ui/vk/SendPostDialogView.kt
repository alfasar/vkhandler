package com.example.vkhandler.android.ui.vk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.vkhandler.presentation.PostViewModel
import org.koin.androidx.compose.getViewModel

private const val EMPTY_STRING = ""

@Composable
fun SendPostDialog(
    viewModel: PostViewModel = getViewModel(),
    onDismiss: () -> Unit
) = Dialog(onDismissRequest = onDismiss) {

    Column(
        modifier = Modifier
            .padding(20.dp)
            .height(300.dp)
            .width(400.dp)
            .background(Color.White)
    ) {

        val textFieldValue = remember { mutableStateOf(EMPTY_STRING) }

        Text(
            text = "Write your post down below",
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
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Button(
            onClick = {
                if (textFieldValue.value.isNotEmpty()) {
                    viewModel.makePost(textFieldValue.value)
                    textFieldValue.value = EMPTY_STRING
                }
            },
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text(
                text = "Send Post",
                color = Color.White
            )
        }
    }

}