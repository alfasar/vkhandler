package com.example.vkhandler.android

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.vkhandler.di.initKoin
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
            }
        )
    }

}