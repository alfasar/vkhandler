package com.example.vkhandler.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

expect val platformModule: Module

fun initKoin(
    appModule: Module
): KoinApplication = startKoin {
    modules(
        appModule,
        databaseModule,
        platformModule
    )
}