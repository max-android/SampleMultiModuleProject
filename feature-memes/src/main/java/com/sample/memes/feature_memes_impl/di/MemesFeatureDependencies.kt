package com.sample.memes.feature_memes_impl.di

import com.sample.injector.BaseDependencies
import com.sample.navigation.core_nav_impl.Navigator

interface MemesFeatureDependencies: BaseDependencies {

    //fun apiRestService(): ApiRestService

    fun navigator(): Navigator

}