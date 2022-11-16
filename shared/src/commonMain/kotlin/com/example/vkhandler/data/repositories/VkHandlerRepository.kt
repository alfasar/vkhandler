package com.example.vkhandler.data.repositories

import com.example.vkhandler.data.datasource.PhotoDatasource
import com.example.vkhandler.data.datasource.PostDatasource
import com.example.vkhandler.data.network.api.VkApi
import com.example.vkhandler.data.network.response.PhotoResponse
import com.example.vkhandler.data.network.response.PostResponse
import com.example.vkhandler.domain.model.Photo
import com.example.vkhandler.domain.model.Post
import com.example.vkhandler.util.extensions.mapSuspendedCatching
import com.example.vkhandler.util.helpers.ResponseHelper.getResponseResult
import com.example.vkhandler.util.mappers.toData
import com.example.vkhandler.util.mappers.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VkHandlerRepository(
    private val photoDatasource: PhotoDatasource,
    private val postDatasource: PostDatasource,
    private val preferenceRepository: PreferenceRepository
) {

    suspend fun updatePhotos(): Result<Unit> =
        getResponseResult { VkApi.fetchAllPhotos() }
            .mapSuspendedCatching { photosResponse ->
                photosResponse.items.forEach { insertPhotos(it) }
            }

    suspend fun updatePosts(): Result<Unit> =
        getResponseResult { VkApi.fetchAllPosts() }
            .mapSuspendedCatching { postsResponse ->
                postsResponse.items.forEach { insertPosts(it) }
            }

    private suspend fun getPostById(postId: Int): Result<Unit> {
        val userId = preferenceRepository.userId
        return getResponseResult { VkApi.getPostById("${userId}_$postId") }
            .mapSuspendedCatching {
                postDatasource.insertPosts(it.first().toData())
            }
    }

    suspend fun getPhotosLocal(): List<Photo> =
        photoDatasource.getAllPhotos().map { it.toModel() }

    suspend fun getPostsLocal(): List<Post> =
        postDatasource.getAllPosts().map { it.toModel() }

    fun getPostsAsFlow(): Flow<List<Post>> =
        postDatasource.getPostsAsFlow().map {
            it.map { postEntity -> postEntity.toModel() }
        }

    suspend fun makePost(message: String) {
        getResponseResult { VkApi.makePost(message) }
            .onSuccess { getPostById(it.postId) }
    }

    suspend fun editPost(postId: String, message: String) {
        VkApi.editPost(postId, message)
        postDatasource.updatePost(postId.toInt(), message)
    }

    suspend fun deletePost(postId: String) {
        VkApi.deletePost(postId)
        postDatasource.deletePostById(postId.toInt())
    }

    private suspend fun insertPhotos(photoResponse: PhotoResponse) {
        photoDatasource.insertPhotos(photoResponse.toData())
    }

    private suspend fun insertPosts(postResponse: PostResponse) {
        postDatasource.insertPosts(postResponse.toData())
    }

}
