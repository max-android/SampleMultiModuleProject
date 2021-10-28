package com.sample.news.feature_news_impl.di

import com.sample.injector.BaseDependencies
import com.sample.navigation.core_nav_impl.Navigator

interface NewsFeatureDependencies: BaseDependencies {

    //fun apiRestService(): ApiRestService

    fun navigator(): Navigator

}