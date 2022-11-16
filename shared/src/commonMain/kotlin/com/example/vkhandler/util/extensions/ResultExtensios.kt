package com.example.vkhandler.util.extensions

import kotlinx.coroutines.CancellationException

@Suppress("UNCHECKED_CAST")
internal inline fun <T, R> Result<T>.mapResult(transform: (value: T) -> Result<R>): Result<R> =
    when {
        isFailure -> this as Result<R>
        else -> transform(getOrNull() as T)
    }

@Suppress("UNCHECKED_CAST")
internal inline fun <T, R> Result<T>.mapSuspendedCatching(transform: (value: T) -> R): Result<R> {
    return when {
        isFailure -> this as Result<R>
        else -> runSuspendedCatching { transform(getOrNull() as T) }
    }
}

internal inline fun <R> runSuspendedCatching(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: CancellationException) {
        throw e // Coroutines need it to be canceled
    } catch (e: Throwable) {
        Result.failure(e)
    }
}
