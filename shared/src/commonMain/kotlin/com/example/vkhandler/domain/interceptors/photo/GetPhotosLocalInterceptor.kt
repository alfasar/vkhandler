package com.example.vkhandler.domain.interceptors.photo

import com.example.vkhandler.data.repositories.VkHandlerRepository

class GetPhotosLocalInterceptor(
    private val vkHandlerRepository: VkHandlerRepository
) {
    suspend operator fun invoke() = vkHandlerRepository.getPhotosLocal()
}