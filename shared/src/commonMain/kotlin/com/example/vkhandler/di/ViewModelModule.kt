package com.example.vkhandler.di

import com.example.vkhandler.presentation.PhotoViewModel
import com.example.vkhandler.presentation.PostViewModel
import org.koin.dsl.module

val viewModelModule = module {

    single { PhotoViewModel(get()) }
    single { PostViewModel(get(), get()) }

}