package com.example.vkhandler.util.helpers

import com.example.vkhandler.data.network.response.BaseResponse
import com.example.vkhandler.data.network.response.ErrorResponse
import com.example.vkhandler.domain.isNetworkAvailable
import com.example.vkhandler.util.exceptions.NoConnectionException
import com.example.vkhandler.util.extensions.mapResult
import io.ktor.network.sockets.SocketTimeoutException
import kotlinx.coroutines.CancellationException

internal object ResponseHelper {

    suspend fun <T : Any> getResponseResult(call: suspend () -> BaseResponse<T>): Result<T> =
        networkCall(call).mapResult { getResult(it.response, null) }

    private suspend fun <T : Any> networkCall(form: suspend () -> T): Result<T> =
        try {
            if (isNetworkAvailable()) {
                Result.success(form.invoke()) // todo check network
            } else {
                Result.failure(NoConnectionException())
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: SocketTimeoutException) {
            Result.failure(Exception(e))
        } catch (e: Throwable) {
            Result.failure(e)
        }

    private fun <T: Any> getResult(
        response: T?,
        errorResponse: ErrorResponse?
    ): Result<T> =
        when {
            response != null && errorResponse == null -> Result.success(response)
            else -> Result.failure(Exception())
        }
}
