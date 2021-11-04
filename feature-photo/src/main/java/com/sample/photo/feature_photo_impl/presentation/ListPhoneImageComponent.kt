package com.sample.photo.feature_photo_impl.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.sample.network.core_network_impl.data.model.BaseModel
import com.sample.network.core_network_impl.data.model.PhotoModel
import com.sample.theme.ui.EmptyListUi
import com.sample.theme.ui.LoadError
import androidx.compose.runtime.getValue
import com.sample.photo.R

@Composable
fun ListPhotoComponent(
    viewModel: PhotoViewModel,
    navigateToPhoto: (PhotoModel) -> Unit
) {
    val state: PhotoState? by viewModel.state.collectAsState()
    ObserveState(state = state, navigateToPhoto)
}

@Composable
private fun ObserveState(
    state: PhotoState?, navigateToPhoto: (PhotoModel) -> Unit
) {
    state?.let { photoState ->
        when (photoState) {
            is SuccessPhoto -> {
                PhotoUi(photoState.photoModels, navigateToPhoto)
            }
            is ErrorPhoto -> {
                LoadError()
            }
            is EmptyPhoto -> {
                EmptyListUi()
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PhotoUi(
    listPhotos: List<BaseModel>,
    navigateToPhoto: (PhotoModel) -> Unit
) {

    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 120.dp)
    ) {
        itemsIndexed(listPhotos) { _, item ->
            if (item is PhotoModel) {
                PhotoItem(item, navigateToPhoto)
            }
        }
    }

}

@Composable
private fun PhotoItem(photo: PhotoModel, click: (PhotoModel) -> Unit) {
    Image(
        painter = rememberImagePainter(
            data = photo.downloadUrl,
            builder = {
                crossfade(true)
                placeholder(R.drawable.ic_placeholder)
            }
        ),
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp)
            .graphicsLayer {
                clip = true
            }
            .clickable { click.invoke(photo) }
    )
}