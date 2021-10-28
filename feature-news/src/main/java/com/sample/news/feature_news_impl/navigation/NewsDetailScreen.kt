package com.sample.news.feature_news_impl.navigation

import androidx.fragment.app.Fragment
import com.github.terrakok.modo.android.AppScreen
import com.sample.news.feature_news_impl.presentation.NewsDetailFragment
import kotlinx.parcelize.Parcelize

@Parcelize
class NewsDetailScreen : AppScreen("NewsDetailScreen") {
    override fun create(): Fragment {
        return NewsDetailFragment()
    }
}