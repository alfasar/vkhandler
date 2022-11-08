package com.example.vkhandler.data.repositories

import com.example.vkhandler.data.datasource.PhotoDatasource
import com.example.vkhandler.data.datasource.PostDatasource
import com.example.vkhandler.data.network.api.VkApi
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

    suspend fun getPhotosRemote(): List<Photo> {
        val photosResponse = VkApi.fetchAllPhotos().response
        photosResponse?.items?.forEach { insertPhotos(it) }
        return photosResponse?.items?.map { it.toModel() } ?: emptyList()
    }

    suspend fun getPostsRemote(): List<Post> {
        val postsResponse = VkApi.fetchAllPosts().response
        postsResponse?.items?.forEach { insertPosts(it) }
        return postsResponse?.items?.map { it.toModel() } ?: emptyList()
    }

    suspend fun getPhotosLocal(): List<Photo> =
        photoDatasource.getAllPhotos().map { it.toModel() }

    suspend fun getPostsLocal(): List<Post> =
        postDatasource.getAllPosts().map { it.toModel() }

    suspend fun makePost(message: String) {
        VkApi.makePost(message)
    }

    suspend fun deletePost(postId: String) {
        VkApi.deletePost(postId)
    }

    private suspend fun insertPhotos(photoResponse: PhotoResponse) {
        photoDatasource.insertPhotos(photoResponse.toData())
    }

    private suspend fun insertPosts(postResponse: PostResponse) {
        postDatasource.insertPosts(postResponse.toData())
    }

}
