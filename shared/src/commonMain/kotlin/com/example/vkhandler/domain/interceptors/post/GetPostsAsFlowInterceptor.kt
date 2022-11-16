package com.example.vkhandler.domain.interceptors.post

import com.example.vkhandler.data.repositories.VkHandlerRepository
import com.example.vkhandler.domain.model.Post
import kotlinx.coroutines.flow.Flow

class GetPostsAsFlowInterceptor(
    private val vkHandlerRepository: VkHandlerRepository
) {
    operator fun invoke(): Flow<List<Post>> = vkHandlerRepository.getPostsAsFlow()
}
