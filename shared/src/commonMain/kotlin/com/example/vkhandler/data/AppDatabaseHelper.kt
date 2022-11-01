package com.example.vkhandler.data

import com.example.vkhandler.AppDatabase
import com.squareup.sqldelight.db.SqlDriver

class AppDatabaseHelper(sqlDriver: SqlDriver) {

    private val db: AppDatabase = AppDatabase(sqlDriver)

    val queries = db.appDatabaseQueries
}