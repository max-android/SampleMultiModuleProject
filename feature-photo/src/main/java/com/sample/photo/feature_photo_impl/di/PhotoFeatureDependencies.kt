package com.sample.photo.feature_photo_impl.di

import com.sample.injector.BaseDependencies
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.network.core_network_impl.data.rest.PhotoRestService

interface PhotoFeatureDependencies: BaseDependencies {

    fun apiPhotoRestService(): PhotoRestService

    fun navigator(): Navigator

}