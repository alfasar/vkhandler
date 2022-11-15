package com.example.vkhandler.domain

import kotlin.coroutines.CoroutineContext

internal actual val DispatcherIO: CoroutineContext
    get() = IosMainDispatcher
