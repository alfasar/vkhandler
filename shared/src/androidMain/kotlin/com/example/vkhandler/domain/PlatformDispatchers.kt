package com.example.vkhandler.domain

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal actual val DispatcherIO: CoroutineContext
    get() = Dispatchers.IO
