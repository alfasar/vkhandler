package com.example.vkhandler.data.datasource

import com.example.vkhandler.data.AppDatabaseHelper
import com.example.vkhandler.data.PhotoEntity
import com.example.vkhandler.domain.DispatcherIO
import kotlinx.coroutines.withContext

class PhotoDatasource(
    private val db: AppDatabaseHelper
) {

    suspend fun getAllPhotos(): List<PhotoEntity> =
        withContext(DispatcherIO) { // todo check on withContext
            db.queries.getAllPhotos().executeAsList()
        }

    suspend fun insertPhotos(photoEntity: PhotoEntity) {
        withContext(DispatcherIO) {
            db.queries.insertPhotos(photoEntity)
        }
    }

}
