package com.example.vkhandler.presentation

import com.example.vkhandler.domain.interceptors.post.DeletePostInterceptor
import com.example.vkhandler.domain.interceptors.post.GetPostsInterceptor
import com.example.vkhandler.domain.interceptors.post.MakePostInterceptor
import com.example.vkhandler.domain.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val getPostsInterceptor: GetPostsInterceptor,
    private val makePostInterceptor: MakePostInterceptor,
    private val deletePostInterceptor: DeletePostInterceptor
) : CommonViewModel() {

    private val _posts = MutableSharedFlow<List<Post>>()
    val posts: SharedFlow<List<Post>> = _posts

    init {
        CoroutineScope(Dispatchers.Default).launch {
            val postsRemote = getPostsInterceptor.invoke()
            _posts.emit(postsRemote)
        }
    }

    fun makePost(message: String) {
        CoroutineScope(Dispatchers.Default).launch {
            makePostInterceptor.invoke(message)
        }
    }

    fun deletePost(postId: String) {
        CoroutineScope(Dispatchers.Default).launch {
            deletePostInterceptor.invoke(postId)
        }
    }

}
