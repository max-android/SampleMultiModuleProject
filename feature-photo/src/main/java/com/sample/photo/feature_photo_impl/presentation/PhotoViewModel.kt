package com.sample.photo.feature_photo_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.modo.forward
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.network.core_network_impl.data.model.PhotoModel
import com.sample.photo.feature_photo_impl.data.PhotoRepository
import com.sample.photo.feature_photo_impl.di.PhotoFeatureComponentHolder
import com.sample.photo.feature_photo_impl.navigation.PhotoDetailScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotoViewModel : ViewModel() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    internal lateinit var repository: PhotoRepository

    private val _state = MutableStateFlow<PhotoState?>(null)
    val state: StateFlow<PhotoState?> = _state.asStateFlow()

    init {
        PhotoFeatureComponentHolder.getComponent().inject(this)
        showContent()
    }

    private fun showContent() {
        viewModelScope.launch {
            _state.emit(repository.loadPhotoData())
        }
    }

    fun clickOnItem(photoModel: PhotoModel) {
        navigator.getRouter().forward(PhotoDetailScreen(photoModel))
    }

    override fun onCleared() {
        super.onCleared()
        PhotoFeatureComponentHolder.reset()
    }

}