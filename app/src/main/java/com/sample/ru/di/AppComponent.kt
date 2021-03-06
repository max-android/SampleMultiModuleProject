package com.sample.ru.di

import com.sample.memes.feature_memes_api.MemesFeatureApi
import com.sample.navigation.core_nav_api.NavigatorApi
import com.sample.network.core_network_api.CoreNetworkApi
import com.sample.news.feature_news_api.NewsFeatureApi
import com.sample.photo.feature_photo_api.PhotoFeatureApi
import com.sample.ru.App
import com.sample.ru.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
abstract class AppComponent {

    abstract fun inject(application: App)
    abstract fun inject(mainActivity: MainActivity)

    //core компоненты инициализируются на уровне App
    abstract fun plusNavigatorApi(): NavigatorApi
    abstract fun plusNetworkApi(): CoreNetworkApi

    //Feature компоненты инициализируются по необходимости и удаляются при уходе с фичи
    abstract fun plusMemesFeatureApi(): MemesFeatureApi
    abstract fun plusNewsFeatureApi(): NewsFeatureApi
    abstract fun plusPhotoFeatureApi(): PhotoFeatureApi

    companion object {

        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return instance
                ?: throw RuntimeException("AppComponent is not initialized yet. Call init first.")
        }

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component
        }
    }
}