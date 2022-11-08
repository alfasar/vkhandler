package com.example.vkhandler.domain.interceptors

import com.example.vkhandler.data.repositories.VkHandlerRepository

class MakePostInterceptor(
    private val vkHandlerRepository: VkHandlerRepository
) {

    suspend operator fun invoke(message: String) {
        vkHandlerRepository.makePost(message)
    }

}