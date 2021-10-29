package com.sample.photo.feature_photo_impl.di

import com.sample.network.core_network_impl.data.rest.PhotoRestService
import com.sample.photo.feature_photo_impl.data.PhotoRepository
import dagger.Module
import dagger.Provides

@Module
internal class PhotoFeatureModule {

    @PhotoFeature
    @Provides
    fun provideRepo(apiRestService: PhotoRestService): PhotoRepository = PhotoRepository(apiRestService)

}