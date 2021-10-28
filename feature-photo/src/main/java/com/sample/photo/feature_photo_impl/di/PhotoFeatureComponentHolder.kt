package com.sample.photo.feature_photo_impl.di

import com.sample.injector.ComponentHolder
import com.sample.photo.feature_photo_api.PhotoFeatureApi

object PhotoFeatureComponentHolder : ComponentHolder<PhotoFeatureApi, PhotoFeatureDependencies> {

    private var photoFeatureComponent: PhotoFeatureComponent? = null

    override fun init(dependencies: PhotoFeatureDependencies) {
        if (photoFeatureComponent == null) {
            synchronized(PhotoFeatureComponentHolder::class.java) {
                if (photoFeatureComponent == null) {
                    photoFeatureComponent = PhotoFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): PhotoFeatureApi {
        return getComponent()
    }

    override fun reset() {
        photoFeatureComponent = null
    }

    internal fun getComponent(): PhotoFeatureComponent {
        checkNotNull(photoFeatureComponent) { "PhotoFeatureComponent was not initialized!" }
        return photoFeatureComponent!!
    }

}