package com.sample.news.feature_news_impl.navigation

import androidx.fragment.app.Fragment
import com.github.terrakok.modo.android.AppScreen
import com.sample.news.feature_news_impl.presentation.NewsFragment
import kotlinx.parcelize.Parcelize

@Parcelize
class NewsScreen : AppScreen("NewsScreen") {
    override fun create(): Fragment {
        return NewsFragment()
    }
}