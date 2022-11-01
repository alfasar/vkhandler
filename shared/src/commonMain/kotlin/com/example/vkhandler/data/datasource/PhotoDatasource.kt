package com.example.vkhandler.data.datasource

import com.example.vkhandler.data.AppDatabaseHelper
import com.example.vkhandler.data.PhotoEntity

class PhotoDatasource(
    private val db: AppDatabaseHelper
) {

    suspend fun getAllPhotos(): List<PhotoEntity> =
        db.queries.getAllPhotos().executeAsList()

    suspend fun insertPhotos(photoEntity: PhotoEntity) {
        db.queries.insertPhotos(photoEntity)
    }

}