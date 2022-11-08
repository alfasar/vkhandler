package com.example.vkhandler.di

import com.example.vkhandler.domain.interceptors.GetPhotosInterceptor
import com.example.vkhandler.domain.interceptors.GetPostsInterceptor
import com.example.vkhandler.domain.interceptors.MakePostInterceptor
import org.koin.dsl.module

val interceptorModule = module {

    single { GetPhotosInterceptor(get()) }
    single { GetPostsInterceptor(get()) }
    single { MakePostInterceptor(get()) }

}