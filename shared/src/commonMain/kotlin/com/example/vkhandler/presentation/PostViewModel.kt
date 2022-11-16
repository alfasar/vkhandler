package com.example.vkhandler.presentation

import com.example.vkhandler.domain.interceptors.post.PostInterceptor
import com.example.vkhandler.domain.interceptors.post.GetPostsRemoteInterceptor
import com.example.vkhandler.domain.interceptors.post.GetPostsLocalInterceptor
import com.example.vkhandler.domain.DispatcherIO
import com.example.vkhandler.domain.interceptors.post.GetPostsAsFlowInterceptor
import com.example.vkhandler.domain.model.Post
import com.example.vkhandler.util.scope.sharedScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val getPostsInterceptor: GetPostsRemoteInterceptor,
    private val getPostsLocalInterceptor: GetPostsLocalInterceptor,
    private val getPostsAsFlowInterceptor: GetPostsAsFlowInterceptor,
    private val postInterceptor: PostInterceptor
) : CommonViewModel() {

    private val _posts = MutableSharedFlow<List<Post>>()
    val posts: SharedFlow<List<Post>> = _posts

    // For Android
    val postFlow: Flow<List<Post>> = getPostsAsFlowInterceptor()

    init { updatePosts() }

    private fun updatePosts() {
        sharedScope(DispatcherIO).launch {
            getPostsInterceptor()
                .onSuccess {
                    val posts = getPostsLocalInterceptor()
                    _posts.emit(posts)
                }
        }
    }

    fun makePost(message: String) {
        sharedScope(DispatcherIO).launch {
            postInterceptor.invoke(message)
        }
    }

    fun editPost(postId: Int, message: String) {
        sharedScope(DispatcherIO).launch {
            postInterceptor.invoke(postId, message)
        }
    }

    fun deletePost(postId: Int) {
        sharedScope(DispatcherIO).launch {
            postInterceptor.invoke(postId)
        }
    }
}
