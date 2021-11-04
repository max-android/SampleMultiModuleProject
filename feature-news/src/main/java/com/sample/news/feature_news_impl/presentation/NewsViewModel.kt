package com.sample.news.feature_news_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.modo.forward
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.network.core_network_impl.data.model.ArticleModel
import com.sample.news.feature_news_impl.data.NewsRepository
import com.sample.news.feature_news_impl.di.NewsFeatureComponentHolder
import com.sample.news.feature_news_impl.navigation.NewsDetailScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel : ViewModel() {

    @Inject
    lateinit var navigator: Navigator
    @Inject
    internal lateinit var repository: NewsRepository

    private val _state = MutableStateFlow<NewsState?>(null)
    val state: StateFlow<NewsState?> = _state.asStateFlow()

    init {
        NewsFeatureComponentHolder.getComponent().inject(this)
        showContent()
    }

    private fun showContent() {
        viewModelScope.launch {
            _state.emit(repository.loadNewsData())
        }
    }

    fun clickOnItem(articleModel: ArticleModel) {
        navigator.getRouter().forward(NewsDetailScreen(articleModel))
    }

    override fun onCleared() {
        super.onCleared()
        NewsFeatureComponentHolder.reset()
    }

}