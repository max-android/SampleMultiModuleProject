package com.sample.news.feature_news_impl.di


import com.sample.news.feature_news_api.NewsFeatureApi
import com.sample.news.feature_news_impl.presentation.NewsViewModel
import dagger.Component

@Component(modules = [NewsFeatureModule::class], dependencies = [NewsFeatureDependencies::class])
@NewsFeature
internal abstract class NewsFeatureComponent: NewsFeatureApi {

    abstract fun inject(newsViewModel: NewsViewModel)

    companion object {
        fun initAndGet(newsFeatureDependencies: NewsFeatureDependencies): NewsFeatureComponent {
            return DaggerNewsFeatureComponent.builder()
                .newsFeatureDependencies(newsFeatureDependencies)
                .build()
        }
    }

}