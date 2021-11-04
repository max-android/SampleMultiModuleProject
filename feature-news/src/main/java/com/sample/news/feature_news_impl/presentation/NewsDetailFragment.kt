package com.sample.news.feature_news_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.sample.network.core_network_impl.data.model.ArticleModel
import com.sample.news.R
import com.sample.theme.MultiComposeAppTheme
import com.sample.theme.ui.EmptyDetailItemUi
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.ViewWindowInsetObserver

class NewsDetailFragment : Fragment(R.layout.fragment_news_detail) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val windowInsets = ViewWindowInsetObserver(this).start()
        setContent {
            CompositionLocalProvider(LocalWindowInsets provides windowInsets) {
                MultiComposeAppTheme {
                    val article = getArticle()
                    if (article != null) {
                        ArticleUi(article)
                    } else {
                        EmptyDetailItemUi()
                    }
                }
            }
        }
    }

    private fun getArticle(): ArticleModel? = arguments?.getParcelable(NEWS_KEY) as? ArticleModel

    companion object {
        fun newInstance(articleModel: ArticleModel): Fragment = NewsDetailFragment().also { frag ->
            frag.arguments = Bundle().also { bundle ->
                bundle.putParcelable(NEWS_KEY, articleModel)
            }
        }

        private const val NEWS_KEY = "news"
    }


}