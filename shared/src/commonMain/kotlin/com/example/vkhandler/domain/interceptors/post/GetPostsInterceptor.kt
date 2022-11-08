package com.example.vkhandler.domain.interceptors.post

import com.example.vkhandler.data.repositories.VkHandlerRepository
import com.example.vkhandler.domain.model.Post

class GetPostsInterceptor(
    private val vkHandlerRepository: VkHandlerRepository
) {
    suspend operator fun invoke(): List<Post> = vkHandlerRepository.getPostsRemote()
}