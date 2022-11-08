package com.example.vkhandler.domain.interceptors

import com.example.vkhandler.data.repositories.VkHandlerRepository
import com.example.vkhandler.domain.model.Photo

class GetPhotosInterceptor(
    private val vkHandlerRepository: VkHandlerRepository
) {

    suspend operator fun invoke(): List<Photo> {
        return vkHandlerRepository.getPhotosRemote()
    }

}