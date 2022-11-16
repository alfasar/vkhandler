package com.example.vkhandler.di

import com.example.vkhandler.domain.interceptors.photo.GetPhotosRemoteInterceptor
import com.example.vkhandler.domain.interceptors.photo.GetPhotosLocalInterceptor
import com.example.vkhandler.domain.interceptors.post.PostInterceptor
import com.example.vkhandler.domain.interceptors.post.GetPostsAsFlowInterceptor
import com.example.vkhandler.domain.interceptors.post.GetPostsRemoteInterceptor
import com.example.vkhandler.domain.interceptors.post.GetPostsLocalInterceptor
import org.koin.dsl.module

val interceptorModule = module {

    single { GetPhotosRemoteInterceptor(get()) }
    single { GetPhotosLocalInterceptor(get()) }

    single { GetPostsRemoteInterceptor(get()) }
    single { GetPostsLocalInterceptor(get()) }
    single { GetPostsAsFlowInterceptor(get()) }
    single { PostInterceptor(get()) }

}
