package com.example.vkhandler.android.ui.vk

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.vkhandler.presentation.PhotoViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun PhotoView(
    viewModel: PhotoViewModel = getViewModel(),
) {
    Column {
        PhotoContentView(viewModel)
    }
}

@Composable
private fun PhotoContentView(
    viewModel: PhotoViewModel
) {

    val photoList = viewModel.photos.collectAsState(initial = emptyList()).value

    Box {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                items = photoList
            ) { photo ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(photo.url)
                        .crossfade(true)
                        .build(),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
            }
        }
    }
}
