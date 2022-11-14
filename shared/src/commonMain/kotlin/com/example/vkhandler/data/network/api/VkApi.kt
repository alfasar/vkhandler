package com.example.vkhandler.data.network.api

import com.example.vkhandler.data.network.response.BaseResponse
import com.example.vkhandler.data.network.response.PhotosResponse
import com.example.vkhandler.data.network.response.PostsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.native.concurrent.ThreadLocal

// Schema-Host
private const val BASE_URL = "https://api.vk.com"

// Paths
private const val GET_PHOTOS = "$BASE_URL/method/photos.getAll"
private const val GET_POSTS = "$BASE_URL/method/wall.get"
private const val SEND_POST = "$BASE_URL/method/wall.post"
private const val EDIT_POST = "$BASE_URL/method/wall.edit"
private const val DELETE_POST = "$BASE_URL/method/wall.delete"

// Parameters
private const val ACCESS_TOKEN = "access_token"
private const val CLIENT_ID = "51424366"
private const val VERSION = "v"
private const val API_VERSION = "5.131"
private const val SCOPE = "photos,offline,wall"

@ThreadLocal
internal object VkApi {

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

    suspend fun fetchAllPhotos(token: String): BaseResponse<PhotosResponse> =
        client.get {
            url(GET_PHOTOS)
            parameter(ACCESS_TOKEN, token)
            parameter(VERSION, API_VERSION)
        }.body()

    suspend fun fetchAllPosts(token: String): BaseResponse<PostsResponse> =
        client.get {
            url(GET_POSTS)
            parameter(ACCESS_TOKEN, token)
            parameter(VERSION, API_VERSION)
        }.body()

    suspend fun makePost(token: String, message: String) {
        client.post {
            url(SEND_POST)
            parameter(ACCESS_TOKEN, token)
            parameter(VERSION, API_VERSION)
            parameter("message", message)
        }
    }

    suspend fun editPost(token: String, postId: String, message: String) {
        client.post {
            url(EDIT_POST)
            parameter(ACCESS_TOKEN, token)
            parameter(VERSION, API_VERSION)
            parameter("post_id", postId)
            parameter("message", message)
        }
    }

    suspend fun deletePost(token: String, postId: String) {
        client.post {
            url(DELETE_POST)
            parameter(ACCESS_TOKEN, token)
            parameter(VERSION, API_VERSION)
            parameter("post_id", postId)
        }
    }
}
