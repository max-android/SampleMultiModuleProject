package com.sample.photo.feature_photo_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.modo.forward
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.photo.feature_photo_impl.data.PhotoRepository
import com.sample.photo.feature_photo_impl.di.PhotoFeatureComponentHolder
import com.sample.photo.feature_photo_impl.navigation.PhotoDetailScreen
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class PhotoViewModel: ViewModel() {

    @Inject
    lateinit var navigator: Navigator
    @Inject
    internal lateinit var repository: PhotoRepository

    init {
        PhotoFeatureComponentHolder.getComponent().inject(this)
    }

    fun showContent() {
        viewModelScope.launch {
            try {
                (repository.loadPhotoData() as SuccessPhoto).photoModels.forEach {
                    Timber.tag("--DATA").i("---Photo:"+it.toString())
                }
            } catch (e: Exception) {

            }
        }
    }

    fun clickOnItem() {
        navigator.getRouter().forward(PhotoDetailScreen())
    }

    override fun onCleared() {
        super.onCleared()
        PhotoFeatureComponentHolder.reset()
    }

}