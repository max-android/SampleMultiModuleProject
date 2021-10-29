package com.sample.news.feature_news_impl.data

import com.sample.network.core_network_impl.data.rest.NewsRestService
import com.sample.network.core_network_impl.data.utils.getBodyDto
import com.sample.news.feature_news_impl.di.NewsFeature
import com.sample.news.feature_news_impl.presentation.ErrorNews
import com.sample.news.feature_news_impl.presentation.NewsState
import com.sample.news.feature_news_impl.presentation.SuccessNews
import javax.inject.Inject

@NewsFeature
internal class NewsRepository @Inject constructor(private val apiService: NewsRestService) {

    suspend fun loadNewsData(): NewsState {
        return try {
            val articles = apiService.articles()
            SuccessNews(articles.getBodyDto())
        } catch (throwable: Throwable) {
            ErrorNews(throwable)
        }
    }

}