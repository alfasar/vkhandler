package com.example.vkhandler.di

import com.example.vkhandler.AppDatabase
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.dsl.module

actual val platformModule = module {
    single<SqlDriver> { AndroidSqliteDriver(AppDatabase.Schema, get(), "AppDatabase") }
    single<Settings> { SharedPreferencesSettings(get()) }
}