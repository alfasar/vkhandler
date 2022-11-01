package com.example.vkhandler.data.repositories

import com.example.vkhandler.data.datasource.PhotoDatasource
import com.example.vkhandler.data.datasource.PostDatasource
import com.example.vkhandler.data.network.response.PhotoResponse
import com.example.vkhandler.data.network.response.PostResponse
import com.example.vkhandler.domain.model.Photo
import com.example.vkhandler.domain.model.Post
import com.example.vkhandler.util.mappers.toData
import com.example.vkhandler.util.mappers.toModel

class VkHandlerRepository(
    private val photoDatasource: PhotoDatasource,
    private val postDatasource: PostDatasource
) {

    suspend fun getAllPhotos(): List<Photo> =
        photoDatasource.getAllPhotos().map { it.toModel() }

    suspend fun getAllPosts(): List<Post> =
        postDatasource.getAllPosts().map { it.toModel() }

    suspend fun insertPhotos(photoResponse: PhotoResponse) {
        photoDatasource.insertPhotos(photoResponse.toData())
    }

    suspend fun insertPosts(postResponse: PostResponse) {
        postDatasource.insertPosts(postResponse.toData())
    }

}
