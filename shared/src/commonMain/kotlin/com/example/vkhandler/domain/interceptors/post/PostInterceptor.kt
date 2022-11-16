package com.example.vkhandler.domain.interceptors.post

import com.example.vkhandler.data.repositories.VkHandlerRepository

class PostInterceptor(
    private val vkHandlerRepository: VkHandlerRepository
) {

    suspend operator fun invoke(message: String) {
        vkHandlerRepository.makePost(message)
    }

    suspend operator fun invoke(postId: Int, message: String) {
        vkHandlerRepository.editPost(postId.toString(), message)
    }

    suspend operator fun invoke(postId: Int) {
        vkHandlerRepository.deletePost(postId.toString())
    }

}
