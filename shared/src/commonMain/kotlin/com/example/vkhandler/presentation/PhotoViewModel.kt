package com.example.vkhandler.presentation

import com.example.vkhandler.domain.interceptors.photo.GetPhotosRemoteInterceptor
import com.example.vkhandler.domain.interceptors.photo.GetPhotosLocalInterceptor
import com.example.vkhandler.domain.DispatcherIO
import com.example.vkhandler.domain.model.Photo
import com.example.vkhandler.util.scope.sharedScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class PhotoViewModel(
    private val getPhotosInterceptor: GetPhotosRemoteInterceptor,
    private val getPhotosLocalInterceptor: GetPhotosLocalInterceptor
) : CommonViewModel() {

    private val _photos = MutableSharedFlow<List<Photo>>()
    val photos: SharedFlow<List<Photo>> = _photos

    init { updatePhotos() }

    private fun updatePhotos() {
        sharedScope(DispatcherIO).launch {
            getPhotosInterceptor()
                .onSuccess {
                    val photos = getPhotosLocalInterceptor()
                    _photos.emit(photos)
                }
        }
    }
}
