package com.example.vkhandler.data.network.api

import com.example.vkhandler.data.network.response.BaseResponse
import com.example.vkhandler.data.network.response.PhotosResponse
import com.example.vkhandler.data.network.response.PostsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.native.concurrent.ThreadLocal

// Host
private const val BASE_URL = "https://api.vk.com"

// Paths
private const val GET_PHOTOS = "$BASE_URL/method/photos.getAll"
private const val GET_POSTS = "$BASE_URL/method/wall.get"
private const val SEND_POST = "$BASE_URL/method/wall.post"
private const val DELETE_POST = "$BASE_URL/method/wall.delete"

// Parameters
private const val CLIENT_ID = "51424366"
private const val API_VERSION = "5.131"
private const val SCOPE = "photos,offline,wall"

// Authorization
private const val USER_ID = "749802626"
private const val TOKEN = "vk1.a.RgFFZlJtsPi1_sfiQb09f_q4t2Rd-HptYLbkxf1GD0Gi_NJiwYVtlEb6miiy_BSlORvOxSY9_WOqhJcTWbI2L9PgX4PiXUcmpFl8Aw_Uxj2lkHmEhaeUNbaupV1yH2W6Uz9bb6nGdhdK2evuibP5B2YE_5BpvcLaouVOOpVt9BE8jtNV-dWUqpcaLg0FnHh83ApdacPF-OG-c34pUyCRcw"

@ThreadLocal
object VkApi {

    private val nonStrictJson = Json {
        isLenient = true
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    private val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(nonStrictJson)
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    suspend fun fetchAllPhotos(): BaseResponse<PhotosResponse> =
        client.get {
            url(GET_PHOTOS)
            parameter("user_id", USER_ID)
            parameter("access_token", TOKEN)
            parameter("v", API_VERSION)
        }.body()

    suspend fun fetchAllPosts(): BaseResponse<PostsResponse> =
        client.get {
            url(GET_POSTS)
            parameter("access_token", TOKEN)
            parameter("v", API_VERSION)
        }.body()

    suspend fun makePost(message: String) {
        client.post {
            url(SEND_POST)
            parameter("access_token", TOKEN)
            parameter("message", message)
            parameter("v", API_VERSION)
        }
    }

    suspend fun deletePost(postId: String) {
        client.post {
            url(DELETE_POST)
            parameter("access_token", TOKEN)
            parameter("post_id", postId)
            parameter("v", API_VERSION)
        }
    }
}
