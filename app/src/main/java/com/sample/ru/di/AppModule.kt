package com.sample.ru.di

import android.content.Context
import com.sample.memes.feature_memes_api.MemesFeatureApi
import com.sample.memes.feature_memes_impl.di.MemesFeatureComponentHolder
import com.sample.memes.feature_memes_impl.di.MemesFeatureDependencies
import com.sample.navigation.core_nav_api.NavigatorApi
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.navigation.core_nav_impl.di.NavigatorComponent
import com.sample.network.core_network_impl.data.rest.MemesRestService
import com.sample.network.core_network_impl.data.rest.NewsRestService
import com.sample.network.core_network_impl.data.rest.PhotoRestService
import com.sample.network.core_network_impl.di.CoreNetworkComponent
import com.sample.news.feature_news_api.NewsFeatureApi
import com.sample.news.feature_news_impl.di.NewsFeatureComponentHolder
import com.sample.news.feature_news_impl.di.NewsFeatureDependencies
import com.sample.photo.feature_photo_api.PhotoFeatureApi
import com.sample.photo.feature_photo_impl.di.PhotoFeatureComponentHolder
import com.sample.photo.feature_photo_impl.di.PhotoFeatureDependencies
import com.sample.ru.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return App.appContext
    }

    @Singleton
    @Provides
    fun navigatorApi(): NavigatorApi {
        return NavigatorComponent.get()
    }

    @Singleton
    @Provides
    fun provideMemesFeatureDependencies(): MemesFeatureDependencies {
        return object : MemesFeatureDependencies {
            override fun apiMemesRestService(): MemesRestService {
                return CoreNetworkComponent.get().memesRestService()
            }

            override fun navigator(): Navigator {
                return NavigatorComponent.get().navigator()
            }
        }
    }

    @Provides
    fun provideMemesFeatureComponent(dependencies: MemesFeatureDependencies): MemesFeatureApi {
        MemesFeatureComponentHolder.init(dependencies)
        return MemesFeatureComponentHolder.get()
    }

    @Singleton
    @Provides
    fun provideNewsFeatureDependencies(): NewsFeatureDependencies {
        return object : NewsFeatureDependencies {
            override fun apiNewsRestService(): NewsRestService {
                return CoreNetworkComponent.get().newsRestService()
            }

            override fun navigator(): Navigator {
                return NavigatorComponent.get().navigator()
            }
        }
    }

    @Provides
    fun provideNewsFeatureComponent(dependencies: NewsFeatureDependencies): NewsFeatureApi {
        NewsFeatureComponentHolder.init(dependencies)
        return NewsFeatureComponentHolder.get()
    }

    @Singleton
    @Provides
    fun providePhotoFeatureDependencies(): PhotoFeatureDependencies {
        return object : PhotoFeatureDependencies {
            override fun apiPhotoRestService(): PhotoRestService {
                return CoreNetworkComponent.get().photoRestService()
            }

            override fun navigator(): Navigator {
                return NavigatorComponent.get().navigator()
            }
        }
    }

    @Provides
    fun providePhotoFeatureComponent(dependencies: PhotoFeatureDependencies): PhotoFeatureApi {
        PhotoFeatureComponentHolder.init(dependencies)
        return PhotoFeatureComponentHolder.get()
    }

}