package com.sample.news.feature_news_impl.di

import com.sample.injector.ComponentHolder
import com.sample.news.feature_news_api.NewsFeatureApi

object NewsFeatureComponentHolder : ComponentHolder<NewsFeatureApi, NewsFeatureDependencies> {

    private var newsFeatureComponent: NewsFeatureComponent? = null

    override fun init(dependencies: NewsFeatureDependencies) {
        if (newsFeatureComponent == null) {
            synchronized(NewsFeatureComponentHolder::class.java) {
                if (newsFeatureComponent == null) {
                    newsFeatureComponent = NewsFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): NewsFeatureApi {
        return getComponent()
    }

    override fun reset() {
        newsFeatureComponent = null
    }

    internal fun getComponent(): NewsFeatureComponent {
        checkNotNull(newsFeatureComponent) { "NewsFeatureComponent was not initialized!" }
        return newsFeatureComponent!!
    }

}