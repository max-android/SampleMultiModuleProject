package com.sample.photo.feature_photo_impl.data

import com.sample.network.core_network_impl.data.rest.PhotoRestService
import com.sample.network.core_network_impl.data.utils.getBodyDto
import com.sample.photo.feature_photo_impl.di.PhotoFeature
import com.sample.photo.feature_photo_impl.presentation.ErrorPhoto
import com.sample.photo.feature_photo_impl.presentation.PhotoState
import com.sample.photo.feature_photo_impl.presentation.SuccessPhoto
import javax.inject.Inject

@PhotoFeature
internal class PhotoRepository @Inject constructor(private val apiService: PhotoRestService) {

    suspend fun loadPhotoData(): PhotoState {
        return try {
            val photos = apiService.photos()
            SuccessPhoto(photos.getBodyDto())
        } catch (throwable: Throwable) {
            ErrorPhoto(throwable)
        }
    }

}