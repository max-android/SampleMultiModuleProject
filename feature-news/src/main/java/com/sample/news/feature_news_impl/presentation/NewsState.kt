package com.sample.news.feature_news_impl.presentation

import com.sample.network.core_network_impl.data.model.ArticleModel

sealed class NewsState
class SuccessNews(
    val articleModels: List<ArticleModel>,
): NewsState()
class ErrorNews(val error: Throwable): NewsState()
object EmptyListNews: NewsState()