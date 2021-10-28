package com.sample.photo.feature_photo_impl.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.modo.forward
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.photo.feature_photo_impl.di.PhotoFeatureComponentHolder
import com.sample.photo.feature_photo_impl.navigation.PhotoDetailScreen
import javax.inject.Inject

class PhotoViewModel: ViewModel() {

    @Inject
    lateinit var navigator: Navigator

    init {
        PhotoFeatureComponentHolder.getComponent().inject(this)
    }

    fun clickOnItem() {
        navigator.getRouter().forward(PhotoDetailScreen())
    }

    override fun onCleared() {
        super.onCleared()
        PhotoFeatureComponentHolder.reset()
    }

}