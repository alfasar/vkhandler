package com.example.vkhandler.domain.model

data class Post(
    val id: Int,
    val date: Long,
    val postType: String,
    val text: String
)
