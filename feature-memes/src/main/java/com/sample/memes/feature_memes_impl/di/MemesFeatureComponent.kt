package com.sample.memes.feature_memes_impl.di

import com.sample.memes.feature_memes_api.MemesFeatureApi
import com.sample.memes.feature_memes_impl.presentation.MemesViewModel
import dagger.Component

@Component(modules = [MemesFeatureModule::class], dependencies = [MemesFeatureDependencies::class])
@MemesFeature
internal abstract class MemesFeatureComponent: MemesFeatureApi {

    abstract fun inject(memesViewModel: MemesViewModel)

    companion object {
        fun initAndGet(memesFeatureDependencies: MemesFeatureDependencies): MemesFeatureComponent {
            return DaggerMemesFeatureComponent.builder()
                .memesFeatureDependencies(memesFeatureDependencies)
                .build()
        }
    }

}