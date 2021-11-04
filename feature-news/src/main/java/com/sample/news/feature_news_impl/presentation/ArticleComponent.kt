package com.sample.news.feature_news_impl.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.sample.network.core_network_impl.data.model.ArticleModel
import com.sample.news.feature_news_impl.util.toDate
import com.sample.theme.ui.composeContext
import com.sample.news.R

@Composable
fun ArticleUi(article: ArticleModel) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {
        Image(
            painter = rememberImagePainter(
                data = article.imageUrl,
                builder = {
                    crossfade(true)
                    placeholder(R.drawable.ic_placeholder)
                    transformations(RoundedCornersTransformation(24f))
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .height(600.dp)
                .fillMaxWidth()
                .padding(8.dp)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body1,
            text = article.title,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body2,
            text = article.summary,
        )
        Text(
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onPrimary,
            text = composeContext().getString(
                R.string.new_created, article.publishedAt.toDate(), article.newsSite
            ),
        )
    }
}