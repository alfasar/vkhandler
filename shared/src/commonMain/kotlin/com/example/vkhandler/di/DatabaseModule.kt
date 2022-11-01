package com.example.vkhandler.di

import com.example.vkhandler.data.AppDatabaseHelper
import com.example.vkhandler.data.datasource.PhotoDatasource
import com.example.vkhandler.data.datasource.PostDatasource
import org.koin.dsl.module

val databaseModule = module {
    single { AppDatabaseHelper(get()) }

    single { PhotoDatasource(get()) }
    single { PostDatasource(get()) }
}