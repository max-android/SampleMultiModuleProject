package com.sample.memes.feature_memes_impl.di

import com.sample.injector.ComponentHolder
import com.sample.memes.feature_memes_api.MemesFeatureApi

object MemesFeatureComponentHolder: ComponentHolder<MemesFeatureApi, MemesFeatureDependencies> {

    private var memesFeatureComponent: MemesFeatureComponent? = null

    override fun init(dependencies: MemesFeatureDependencies) {
        if (memesFeatureComponent == null) {
            synchronized(MemesFeatureComponentHolder::class.java) {
                if (memesFeatureComponent == null) {
                    memesFeatureComponent = MemesFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): MemesFeatureApi {
        return getComponent()
    }

    override fun reset() {
        memesFeatureComponent = null
    }

   internal fun getComponent(): MemesFeatureComponent {
        checkNotNull(memesFeatureComponent) { "MemesFeatureComponent was not initialized!" }
        return memesFeatureComponent!!
    }

}