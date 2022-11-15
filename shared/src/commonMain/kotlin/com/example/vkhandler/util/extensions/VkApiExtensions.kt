package com.example.vkhandler.util.extensions

import com.example.vkhandler.data.network.api.VkApi
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

private val nonStrictJson = Json {
    isLenient = true
    ignoreUnknownKeys = true
    prettyPrint = true
}

internal val VkApi.client: HttpClient
    get() = HttpClient {
        install(ContentNegotiation) {
            json(nonStrictJson)
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }
