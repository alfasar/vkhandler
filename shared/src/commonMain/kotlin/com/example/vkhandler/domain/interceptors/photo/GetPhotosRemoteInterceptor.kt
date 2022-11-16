package com.example.vkhandler.domain.interceptors.photo

import com.example.vkhandler.data.repositories.VkHandlerRepository

class GetPhotosRemoteInterceptor(
    private val vkHandlerRepository: VkHandlerRepository
) {
    suspend operator fun invoke(): Result<Unit> = vkHandlerRepository.updatePhotos()
}
