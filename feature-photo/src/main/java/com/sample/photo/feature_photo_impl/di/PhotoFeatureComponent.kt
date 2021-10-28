package com.sample.photo.feature_photo_impl.di

import com.sample.photo.feature_photo_api.PhotoFeatureApi
import com.sample.photo.feature_photo_impl.presentation.PhotoViewModel
import dagger.Component

@Component(modules = [PhotoFeatureModule::class], dependencies = [PhotoFeatureDependencies::class])
@PhotoFeature
internal abstract class PhotoFeatureComponent: PhotoFeatureApi {

    abstract fun inject(photoViewModel: PhotoViewModel)

    companion object {
        fun initAndGet(photoFeatureDependencies: PhotoFeatureDependencies): PhotoFeatureComponent {
            return DaggerPhotoFeatureComponent.builder()
                .photoFeatureDependencies(photoFeatureDependencies)
                .build()
        }
    }

}