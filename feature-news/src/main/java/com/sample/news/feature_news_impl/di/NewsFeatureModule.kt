package com.sample.news.feature_news_impl.di

import com.sample.network.core_network_impl.data.rest.NewsRestService
import com.sample.news.feature_news_impl.data.NewsRepository
import dagger.Module
import dagger.Provides

@Module
internal class NewsFeatureModule {

    @NewsFeature
    @Provides
    fun provideRepo(apiRestService: NewsRestService): NewsRepository = NewsRepository(apiRestService)

}