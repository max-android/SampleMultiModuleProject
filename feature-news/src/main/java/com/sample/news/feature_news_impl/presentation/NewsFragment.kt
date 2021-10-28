package com.sample.news.feature_news_impl.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sample.news.R

class NewsFragment: Fragment(R.layout.fragment_news)  {

    private val viewModel by viewModels<NewsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.showNewsDetailButton).setOnClickListener {
            viewModel.clickOnItem()
        }
    }


}