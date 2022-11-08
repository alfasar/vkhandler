package com.example.vkhandler.data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("response") val response: T?,
    @SerialName("error") val error: ErrorResponse?
)

@Serializable
data class ErrorResponse(
    @SerialName("error_code") val code: Int,
    @SerialName("error_msg") val message: String
)
