package com.sample.memes.feature_memes_impl.presentation

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
import com.sample.core.toDate
import com.sample.network.core_network_impl.data.model.MemModel
import com.sample.memes.R
import com.sample.theme.ui.composeContext

@Composable
fun MemUi(mem: MemModel) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {
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
                .height(600.dp)
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