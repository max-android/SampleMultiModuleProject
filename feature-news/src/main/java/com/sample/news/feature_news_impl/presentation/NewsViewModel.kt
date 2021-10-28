package com.sample.news.feature_news_impl.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.modo.forward
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.news.feature_news_impl.di.NewsFeatureComponentHolder
import com.sample.news.feature_news_impl.navigation.NewsDetailScreen
import javax.inject.Inject

class NewsViewModel : ViewModel() {

    @Inject
    lateinit var navigator: Navigator

    init {
        NewsFeatureComponentHolder.getComponent().inject(this)
    }

    fun clickOnItem() {
        navigator.getRouter().forward(NewsDetailScreen())
    }

    override fun onCleared() {
        super.onCleared()
        NewsFeatureComponentHolder.reset()
    }

}