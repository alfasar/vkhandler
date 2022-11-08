package com.example.vkhandler.di

import com.example.vkhandler.domain.interceptors.post.DeletePostInterceptor
import com.example.vkhandler.domain.interceptors.photo.GetPhotosInterceptor
import com.example.vkhandler.domain.interceptors.post.GetPostsInterceptor
import com.example.vkhandler.domain.interceptors.post.MakePostInterceptor
import org.koin.dsl.module

val interceptorModule = module {

    single { GetPhotosInterceptor(get()) }

    single { GetPostsInterceptor(get()) }
    single { MakePostInterceptor(get()) }
    single { DeletePostInterceptor(get()) }

}
