package com.example.vkhandler.domain.interceptors.post

import com.example.vkhandler.data.repositories.VkHandlerRepository

class GetPostsLocalInterceptor(
    private val vkHandlerRepository: VkHandlerRepository
) {
    suspend operator fun invoke() = vkHandlerRepository.getPostsLocal()
}