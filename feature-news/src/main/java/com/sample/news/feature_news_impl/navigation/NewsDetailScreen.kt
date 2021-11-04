package com.sample.news.feature_news_impl.navigation

import androidx.fragment.app.Fragment
import com.github.terrakok.modo.android.AppScreen
import com.sample.network.core_network_impl.data.model.ArticleModel
import com.sample.news.feature_news_impl.presentation.NewsDetailFragment
import kotlinx.parcelize.Parcelize

@Parcelize
class NewsDetailScreen(private val articleModel: ArticleModel) : AppScreen("NewsDetailScreen") {
    override fun create(): Fragment {
        return NewsDetailFragment.newInstance(articleModel)
    }
}