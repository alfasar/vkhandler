package com.example.vkhandler.data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostsResponse(
    val items: List<PostResponse>
)

@Serializable
data class PostResponse(
    @SerialName("id") val id: Int,
    @SerialName("post_type") val postType: String,
    @SerialName("text") val text: String
)
