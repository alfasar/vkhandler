package com.example.vkhandler.di

import com.example.vkhandler.data.repositories.VkHandlerRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { VkHandlerRepository(get(), get()) }

}