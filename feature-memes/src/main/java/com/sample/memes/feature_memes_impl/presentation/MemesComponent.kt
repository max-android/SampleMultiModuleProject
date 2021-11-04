package com.sample.memes.feature_memes_impl.presentation

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
import com.sample.core.toDate
import com.sample.network.core_network_impl.data.model.BaseModel
import com.sample.network.core_network_impl.data.model.MemModel
import com.sample.theme.ui.composeContext
import androidx.compose.runtime.getValue
import com.sample.theme.ui.EmptyListUi
import com.sample.theme.ui.LoadError
import com.sample.memes.R

@Composable
fun MemesComponent(viewModel: MemesViewModel, navigateToMem: (MemModel) -> Unit) {
    val state: MemesState? by viewModel.state.collectAsState()
    ObserveState(state, navigateToMem)
}

@Composable
private fun ObserveState(state: MemesState?, navigateToMem: (MemModel) -> Unit) {
    state?.let { memState ->
        when (memState) {
            is SuccessMemes -> {
                MemesUi(memState.memes, navigateToMem)
            }
            is EmptyMemes -> {
                EmptyListUi()
            }
            is ErrorMemes -> {
                LoadError()
            }
        }
    }
}

@Composable
private fun MemesUi(listMemes: List<BaseModel>, navigateToMem: (MemModel) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 68.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(listMemes) { _, item ->
            if (item is MemModel) {
                MemItem(item, navigateToMem)
            }
        }
    }
}

@Composable
private fun MemItem(mem: MemModel, click: (MemModel) -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable {
                click.invoke(mem)
            },
        shape = RoundedCornerShape(16.dp),
    ) {
        Column() {
            Image(
                painter = rememberImagePainter(
                    data = mem.memUrl,
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
                text = mem.title,
            )
            Text(
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onPrimary,
                text = composeContext().getString(
                    R.string.memes_created, mem.created.toDate(), mem.author
                ),
            )
        }
    }
}