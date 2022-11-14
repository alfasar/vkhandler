package com.example.vkhandler.presentation

import com.example.vkhandler.domain.interceptors.photo.GetPhotosInterceptor
import com.example.vkhandler.domain.interceptors.photo.GetPhotosLocalInterceptor
import com.example.vkhandler.domain.DispatcherIO
import com.example.vkhandler.domain.model.Photo
import com.example.vkhandler.util.scope.sharedScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class PhotoViewModel(
    private val getPhotosInterceptor: GetPhotosInterceptor,
    private val getPhotosLocalInterceptor: GetPhotosLocalInterceptor
) : CommonViewModel() {

    private val _photos = MutableSharedFlow<List<Photo>>()
    val photos: SharedFlow<List<Photo>> = _photos

    suspend fun get(): List<Photo> {
        return sharedScope(DispatcherIO).async {
            getPhotosInterceptor.invoke()
        }.await()
    }

    init {
        sharedScope(DispatcherIO).launch {
            val photosRemote = getPhotosInterceptor.invoke()
            _photos.emit(photosRemote)
        }
    }
}
