package com.sample.memes.feature_memes_impl.di

import com.sample.injector.BaseDependencies
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.network.core_network_impl.data.rest.MemesRestService

interface MemesFeatureDependencies: BaseDependencies {

    fun apiMemesRestService(): MemesRestService

    fun navigator(): Navigator

}