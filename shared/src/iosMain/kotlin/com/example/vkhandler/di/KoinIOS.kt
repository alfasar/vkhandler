package com.example.vkhandler.di

import com.example.vkhandler.AppDatabase
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

actual val platformModule = module {
    single<SqlDriver> { NativeSqliteDriver(AppDatabase.Schema, "AppDatabase") }
}

object KoinIOS {
    fun initialize(
        userDefaults: NSUserDefaults
    ): KoinApplication = initKoin(
        appModule = module {
            single<Settings> { NSUserDefaultsSettings(userDefaults) }
        }
    )
}

fun Koin.get(objCClass: ObjCClass): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, null, null)
}

fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?,
             parameter: Any): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, qualifier) { parametersOf(parameter) }
}
