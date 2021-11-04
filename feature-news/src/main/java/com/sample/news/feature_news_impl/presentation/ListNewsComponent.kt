package com.sample.news.feature_news_impl.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.sample.network.core_network_impl.data.model.ArticleModel
import com.sample.network.core_network_impl.data.model.BaseModel
import com.sample.theme.ui.EmptyListUi
import com.sample.theme.ui.LoadError
import androidx.compose.runtime.getValue
import com.sample.news.R
import com.sample.news.feature_news_impl.util.toDate
import com.sample.theme.ui.composeContext

@Composable
fun ListNewsComponent(viewModel: NewsViewModel, navigateToArticle: (ArticleModel) -> Unit) {
    val state: NewsState? by viewModel.state.collectAsState()
    ObserveState(state, navigateToArticle)
}

@Composable
private fun ObserveState(state: NewsState?, navigateToArticle: (ArticleModel) -> Unit) {
    state?.let { newsState ->
        when (newsState) {
            is SuccessNews -> {
                NewsUi(newsState.articleModels, navigateToArticle)
            }
            is ErrorNews -> {
                LoadError()
            }
            is EmptyListNews -> {
                EmptyListUi()
            }
        }
    }
}

@Composable
private fun NewsUi(listNews: List<BaseModel>, navigateToArticle: (ArticleModel) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(
            start = 8.dp, end = 8.dp, top = 16.dp, bottom = 68.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(listNews) { index, item ->
            if (item is ArticleModel) {
                ArticleItem(item, index, navigateToArticle)
            }
        }
    }
}

@Composable
private fun ArticleItem(
    article: ArticleModel,
    articlePosition: Int,
    click: (ArticleModel) -> Unit
) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable {
                click.invoke(article)
            },
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp
    ) {
        Column() {
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
                    .height(275.dp)
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary,
                text = article.title,
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
}