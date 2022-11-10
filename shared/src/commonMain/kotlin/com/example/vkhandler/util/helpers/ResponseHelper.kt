package com.example.vkhandler.util.helpers

import com.example.vkhandler.data.network.response.BaseResponse
import com.example.vkhandler.data.network.response.ErrorResponse
import io.ktor.network.sockets.*

object ResponseHelper {


    private suspend fun <RESPONSE : Any> networkCall(
        form: suspend () -> RESPONSE
    ): Result<RESPONSE> {
        return try {
            Result.success(form.invoke())
        } catch (e: SocketTimeoutException) {
            Result.failure(Exception(e))
        }
    }

    private suspend fun <RESPONSE: Any> getResult(
        response: BaseResponse<RESPONSE>?,
        errorResponse: ErrorResponse?
    ): Result<RESPONSE> =
        when {
            response?.response != null && errorResponse == null -> Result.success(response.response)
            else -> Result.failure(Exception())
        }

}
