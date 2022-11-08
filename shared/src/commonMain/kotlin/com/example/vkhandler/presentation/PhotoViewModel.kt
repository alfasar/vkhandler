package com.example.vkhandler.presentation

import com.example.vkhandler.data.repositories.VkHandlerRepository
import com.example.vkhandler.domain.model.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class PhotoViewModel(
    private val vkHandlerRepository: VkHandlerRepository
) : CommonViewModel() {

}