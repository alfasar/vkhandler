package com.example.vkhandler.data.network.api

import com.example.vkhandler.data.network.request.PostRequest
import com.example.vkhandler.data.network.response.BaseResponse
import com.example.vkhandler.data.network.response.PhotosResponse
import com.example.vkhandler.data.network.response.PostResponse
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

private const val TOKEN =
    "vk1.a.RgFFZlJtsPi1_sfiQb09f_q4t2Rd-HptYLbkxf1GD0Gi_NJiwYVtlEb6miiy_BSlORvOxSY9_WOqhJcTWbI2L9PgX4PiXUcmpFl8Aw_Uxj2lkHmEhaeUNbaupV1yH2W6Uz9bb6nGdhdK2evuibP5B2YE_5BpvcLaouVOOpVt9BE8jtNV-dWUqpcaLg0FnHh83ApdacPF-OG-c34pUyCRcw"

private const val get_photos = "photos.getAll"
private const val get_posts = "wall.get"
private const val send_post = "wall.post"
private const val get_post_by_id = "wall.getById"
private const val edit_post = "wall.edit"
private const val delete_post = "wall.delete"

//private const val CLIENT_ID = "51424366"
//private const val SCOPE = "photos,offline,wall"

@ThreadLocal
internal object VkApi {

    private fun baseUrl(path: String) = URLBuilder(
        protocol = URLProtocol.HTTPS,
        host = HOST,
        pathSegments = listOf(METHOD, path),
        parameters = Parameters.build {
            append(access_token, TOKEN)
            append(version, api_version)
        }
    ).buildString()

    suspend fun fetchAllPhotos(): BaseResponse<PhotosResponse> =
        client.get(baseUrl(get_photos)).body()

    suspend fun fetchAllPosts(): BaseResponse<PostsResponse> =
        client.get(baseUrl(get_posts)).body()

    suspend fun getPostById(postId: String): BaseResponse<List<PostResponse>> =
        client.get {
            url(baseUrl(get_post_by_id))
            parameter("posts", postId)
        }.body()

    suspend fun makePost(message: String): BaseResponse<PostRequest> =
        client.post {
            url(baseUrl(send_post))
            parameter("message", message)
        }.body()

    suspend fun editPost(postId: String, message: String) {
        client.post {
            url(baseUrl(edit_post))
            parameter("post_id", postId)
            parameter("message", message)
        }
    }

    suspend fun deletePost(postId: String) {
        client.post {
            url(baseUrl(delete_post))
            parameter("post_id", postId)
        }
    }
}
