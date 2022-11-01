package com.example.vkhandler.util.mappers

import com.example.vkhandler.data.PhotoEntity
import com.example.vkhandler.data.PostEntity
import com.example.vkhandler.data.network.response.PhotoResponse
import com.example.vkhandler.data.network.response.PostResponse
import com.example.vkhandler.domain.model.Photo
import com.example.vkhandler.domain.model.Post

fun PostEntity.toModel() = Post(
    id = this.id,
    postType = this.postType,
    text = this.text
)

fun PhotoEntity.toModel() = Photo(
    date = this.date,
    id = this.id.toInt(),
    height = this.height.toInt(),
    url = this.url,
    type = this.type,
    width = this.width.toString(),
    text = this.text ?: ""
)

fun PhotoResponse.toModel() = Photo(
    date = this.date,
    id = this.id,
    height = this.sizes.last().height,
    url = this.sizes.last().url,
    type = this.sizes.last().type,
    width = this.sizes.last().width,
    text = this.text
)

fun PostResponse.toModel() = Post(
    id = this.id,
    postType = this.postType,
    text = this.text
)