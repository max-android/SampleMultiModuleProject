package com.sample.news.feature_news_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.modo.forward
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.news.feature_news_impl.data.NewsRepository
import com.sample.news.feature_news_impl.di.NewsFeatureComponentHolder
import com.sample.news.feature_news_impl.navigation.NewsDetailScreen
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class NewsViewModel : ViewModel() {

    @Inject
    lateinit var navigator: Navigator
    @Inject
    internal lateinit var repository: NewsRepository

    init {
        NewsFeatureComponentHolder.getComponent().inject(this)
    }

    fun clickOnItem() {
        navigator.getRouter().forward(NewsDetailScreen())
    }

    fun showContent() {
        viewModelScope.launch {
            try {
                (repository.loadNewsData() as SuccessNews).articleModels.forEach {
                    Timber.tag("--DATA").i("---News:"+it.toString())
                }
            } catch (e: Exception) {

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        NewsFeatureComponentHolder.reset()
    }

}