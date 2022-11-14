package com.example.vkhandler.domain

import kotlinx.coroutines.Runnable
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineDispatcher
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

object IosMainDispatcher : CoroutineDispatcher() {

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) { block.run() }
    }

}
