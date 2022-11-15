package com.example.vkhandler.util.scope

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

internal fun sharedScope(context: CoroutineContext) = CoroutineScope(context)
