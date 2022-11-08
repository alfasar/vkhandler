package com.example.vkhandler.android.ui.vk

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
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
    Box {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                items = mockPhotosUrl,
                key = { it }
            ) { item ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item)
                        .crossfade(true)
                        .build(),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
            }
        }
    }
}
private val mockPhotosUrl = listOf(
    "https://sun9-50.userapi.com/impg/iq0yKVjbcc6LGV8I1w9D3WCH68cMSnorN6fs1Q/K_lUz2dvE7w.jpg?size=1280x719&quality=95&sign=10727bb23f4aff455a84392582c696b2&type=album",
    "https://sun9-47.userapi.com/impg/WqG7vymTtEr9gs0gcgOSCtKi2kT9KitFDJgs-w/NMiHT4HNDrc.jpg?size=600x570&quality=96&sign=c8f75da05ea819f4425f18f36df192d3&type=album"
)