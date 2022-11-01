package com.example.vkhandler.data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponse(
    @SerialName("count") val count: Int,
    @SerialName("items") val items: List<PhotoResponse>
)

@Serializable
data class PhotoResponse(
    val date: Long,
    val id: Int,
    val sizes: List<Sizes>,
    val text: String
)

@Serializable
data class Sizes(
    val height: Int,
    val url: String,
    val type: String,
    val width: String
)
