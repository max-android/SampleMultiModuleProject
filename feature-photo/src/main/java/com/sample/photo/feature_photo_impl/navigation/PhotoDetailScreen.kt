package com.sample.photo.feature_photo_impl.navigation

import androidx.fragment.app.Fragment
import com.github.terrakok.modo.android.AppScreen
import com.sample.network.core_network_impl.data.model.PhotoModel
import com.sample.photo.feature_photo_impl.presentation.PhotoDetailFragment
import kotlinx.parcelize.Parcelize

@Parcelize
class PhotoDetailScreen(private val photoModel: PhotoModel) : AppScreen("PhotoDetailScreen") {
    override fun create(): Fragment {
        return PhotoDetailFragment.newInstance(photoModel)
    }
}