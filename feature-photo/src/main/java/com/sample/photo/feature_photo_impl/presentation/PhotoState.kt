package com.sample.photo.feature_photo_impl.presentation

import com.sample.network.core_network_impl.data.model.PhotoModel

sealed class PhotoState
object LoadingPhoto : PhotoState()
class SuccessPhoto(
    val photoModels: List<PhotoModel>,
) : PhotoState()
class ErrorPhoto(val error: Throwable) : PhotoState()