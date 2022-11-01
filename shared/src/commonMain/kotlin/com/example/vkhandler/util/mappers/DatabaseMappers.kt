package com.example.vkhandler.util.mappers

import com.example.vkhandler.data.PhotoEntity
import com.example.vkhandler.data.PostEntity
import com.example.vkhandler.data.network.response.PhotoResponse
import com.example.vkhandler.data.network.response.PostResponse

fun PostResponse.toData() = PostEntity(
    id = this.id,
    postType = this.postType,
    text = this.text
)

fun PhotoResponse.toData() = PhotoEntity(
    date = this.date,
    id = this.id.toLong(),
    height = this.sizes.last().height.toLong(),
    url = this.sizes.last().url,
    type = this.sizes.last().type,
    width = this.sizes.last().width.toLong(),
    text = this.text
)