package com.example.vkhandler.di

import com.example.vkhandler.data.AppDatabaseHelper
import org.koin.dsl.module

val databaseModule = module {
    single { AppDatabaseHelper(get()) }
}