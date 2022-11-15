package com.example.vkhandler.data.network.api

import com.example.vkhandler.data.network.response.BaseResponse
import com.example.vkhandler.data.network.response.PhotosResponse
import com.example.vkhandler.data.network.response.PostsResponse
import com.example.vkhandler.util.extensions.client
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.client.request.parameter
import io.ktor.http.URLProtocol
import io.ktor.http.URLBuilder
import io.ktor.http.Parameters
import kotlin.native.concurrent.ThreadLocal

private const val HOST = "api.vk.com"
private const val METHOD = "method"

private const val access_token = "access_token"
private const val version = "v"
private const val api_version = "5.131"

private const val get_photos = "photos.getAll"
private const val get_posts = "wall.get"
private const val send_post = "wall.post"
private const val edit_post = "wall.edit"
private const val delete_post = "wall.delete"

//private const val CLIENT_ID = "51424366"
//private const val SCOPE = "photos,offline,wall"

@ThreadLocal
internal object VkApi {

    private fun baseUrl(token: String, path: String) = URLBuilder(
        protocol = URLProtocol.HTTPS,
        host = HOST,
        pathSegments = listOf(METHOD, path),
        parameters = Parameters.build {
            append(access_token, token)
            append(version, api_version)
        }
    ).buildString()

    suspend fun fetchAllPhotos(token: String): BaseResponse<PhotosResponse> =
        client.get(baseUrl(token, get_photos)).body()

    suspend fun fetchAllPosts(token: String): BaseResponse<PostsResponse> =
        client.get(baseUrl(token, get_posts)).body()

    suspend fun makePost(token: String, message: String) {
        client.post {
            url(baseUrl(token, send_post))
            parameter("message", message)
        }
    }

    suspend fun editPost(token: String, postId: String, message: String) {
        client.post {
            url(baseUrl(token, edit_post))
            parameter("post_id", postId)
            parameter("message", message)
        }
    }

    suspend fun deletePost(token: String, postId: String) {
        client.post {
            url(baseUrl(token, delete_post))
            parameter("post_id", postId)
        }
    }
}
