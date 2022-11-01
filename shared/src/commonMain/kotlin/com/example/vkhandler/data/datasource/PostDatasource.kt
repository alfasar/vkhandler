package com.example.vkhandler.data.datasource

import com.example.vkhandler.data.AppDatabaseHelper
import com.example.vkhandler.data.PostEntity

class PostDatasource(
    private val db: AppDatabaseHelper
) {

    suspend fun getAllPosts(): List<PostEntity> =
        db.queries.getAllPosts().executeAsList()

    suspend fun insertPosts(postEntity: PostEntity) {
        db.queries.insertPosts(postEntity)
    }

}