package com.sample.photo.feature_photo_impl.di

import com.sample.injector.BaseDependencies
import com.sample.navigation.core_nav_impl.Navigator

interface PhotoFeatureDependencies: BaseDependencies {

    //fun apiRestService(): ApiRestService

    fun navigator(): Navigator

}