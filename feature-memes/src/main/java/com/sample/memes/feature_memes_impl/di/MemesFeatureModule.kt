package com.sample.memes.feature_memes_impl.di

import com.sample.memes.feature_memes_impl.data.MemesRepository
import com.sample.network.core_network_impl.data.rest.MemesRestService
import dagger.Module
import dagger.Provides

@Module
internal class MemesFeatureModule {

    @MemesFeature
    @Provides
    fun provideRepo(apiRestService: MemesRestService): MemesRepository = MemesRepository (apiRestService)

}