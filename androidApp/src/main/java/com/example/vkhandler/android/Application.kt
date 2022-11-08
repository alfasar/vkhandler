package com.example.vkhandler.android

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.vkhandler.di.initKoin
import com.example.vkhandler.presentation.PhotoViewModel
import com.example.vkhandler.presentation.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            appModule = module {
                single<Context> { this@App }
                single<SharedPreferences> { get<Context>().getSharedPreferences(
                    "vkhandler",
                    Context.MODE_PRIVATE
                ) }
            },
            viewModels = module {
                viewModel { PhotoViewModel(get()) }
                viewModel { PostViewModel(get(), get(), get()) }
            }
        )
    }
}