package com.sample.news.feature_news_impl.di

import com.sample.injector.BaseDependencies
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.network.core_network_impl.data.rest.NewsRestService

interface NewsFeatureDependencies: BaseDependencies {

    fun apiNewsRestService(): NewsRestService

    fun navigator(): Navigator

}