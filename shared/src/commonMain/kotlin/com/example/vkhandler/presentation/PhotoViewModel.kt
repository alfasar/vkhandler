package com.example.vkhandler.presentation

import com.example.vkhandler.domain.interceptors.photo.GetPhotosInterceptor
import com.example.vkhandler.domain.model.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class PhotoViewModel(
    private val getPhotosInterceptor: GetPhotosInterceptor
) : CommonViewModel() {

    private val _photos = MutableSharedFlow<List<Photo>>()
    val photos: SharedFlow<List<Photo>> = _photos

    init {
        CoroutineScope(Dispatchers.Default).launch {
            val photosRemote = getPhotosInterceptor.invoke()
            _photos.emit(photosRemote)
        }
    }

}
