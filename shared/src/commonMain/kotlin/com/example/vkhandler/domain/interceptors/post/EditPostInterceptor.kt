package com.example.vkhandler.domain.interceptors.post

import com.example.vkhandler.data.repositories.VkHandlerRepository

class EditPostInterceptor(
    private val vkHandlerRepository: VkHandlerRepository
) {
    suspend operator fun invoke(
        postId: String, message: String
    ) { vkHandlerRepository.editPost(postId, message) }
}
