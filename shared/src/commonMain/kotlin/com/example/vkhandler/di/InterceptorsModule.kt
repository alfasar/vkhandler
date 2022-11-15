package com.example.vkhandler.di

import com.example.vkhandler.domain.interceptors.post.DeletePostInterceptor
import com.example.vkhandler.domain.interceptors.photo.GetPhotosInterceptor
import com.example.vkhandler.domain.interceptors.photo.GetPhotosLocalInterceptor
import com.example.vkhandler.domain.interceptors.post.EditPostInterceptor
import com.example.vkhandler.domain.interceptors.post.GetPostsInterceptor
import com.example.vkhandler.domain.interceptors.post.GetPostsLocalInterceptor
import com.example.vkhandler.domain.interceptors.post.MakePostInterceptor
import org.koin.dsl.module

val interceptorModule = module {

    single { GetPhotosInterceptor(get()) }
    single { GetPhotosLocalInterceptor(get()) }

    single { GetPostsInterceptor(get()) }
    single { MakePostInterceptor(get()) }
    single { EditPostInterceptor(get()) }
    single { DeletePostInterceptor(get()) }
    single { GetPostsLocalInterceptor(get()) }

}
