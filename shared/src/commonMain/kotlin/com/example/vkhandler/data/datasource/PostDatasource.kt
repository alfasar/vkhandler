package com.example.vkhandler.data.datasource

import com.example.vkhandler.data.AppDatabaseHelper
import com.example.vkhandler.data.PostEntity
import com.example.vkhandler.domain.DispatcherIO
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class PostDatasource(
    private val db: AppDatabaseHelper
) {

    fun getPostsAsFlow(): Flow<List<PostEntity>> =
        db.queries.getAllPosts().asFlow().mapToList()

    suspend fun getAllPosts(): List<PostEntity> =
        withContext(DispatcherIO) { // todo check on withContext
            db.queries.getAllPosts().executeAsList()
        }

    suspend fun insertPosts(postEntity: PostEntity) {
        withContext(DispatcherIO) {
            db.queries.insertPosts(postEntity)
        }
    }

    suspend fun updatePost(postId: Int, newValue: String) {
        withContext(DispatcherIO) {
            db.queries.updatePost(newValue, postId)
        }
    }

    suspend fun deletePostById(postId: Int) {
        withContext(DispatcherIO) {
            db.queries.deletePostById(postId)
        }
    }
}
