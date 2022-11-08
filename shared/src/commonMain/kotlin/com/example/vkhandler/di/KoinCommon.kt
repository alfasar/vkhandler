package com.example.vkhandler.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

expect val platformModule: Module

fun initKoin(
    appModule: Module,
    viewModels: Module = viewModelModule
): KoinApplication = startKoin {
    modules(
        appModule,
        viewModels,
        databaseModule,
        repositoryModule,
        platformModule,
        interceptorModule
    )
}