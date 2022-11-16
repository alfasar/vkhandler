package com.example.vkhandler.domain.interceptors.photo

import com.example.vkhandler.data.repositories.VkHandlerRepository
import com.example.vkhandler.domain.model.Photo

class GetPhotosLocalInterceptor(
    private val vkHandlerRepository: VkHandlerRepository
) {
    suspend operator fun invoke(): List<Photo> = vkHandlerRepository.getPhotosLocal()
}
