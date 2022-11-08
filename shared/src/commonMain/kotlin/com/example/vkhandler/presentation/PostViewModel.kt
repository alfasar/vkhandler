package com.example.vkhandler.presentation

import com.example.vkhandler.domain.interceptors.GetPostsInterceptor
import com.example.vkhandler.domain.interceptors.MakePostInterceptor
import com.example.vkhandler.domain.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val getPostsInterceptor: GetPostsInterceptor,
    private val makePostInterceptor: MakePostInterceptor
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

}
