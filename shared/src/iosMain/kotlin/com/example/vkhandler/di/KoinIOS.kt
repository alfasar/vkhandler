package com.example.vkhandler.di

import com.example.vkhandler.AppDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import org.koin.dsl.module

actual val platformModule = module {
    single<SqlDriver> { NativeSqliteDriver(AppDatabase.Schema, "AppDatabase") }
}