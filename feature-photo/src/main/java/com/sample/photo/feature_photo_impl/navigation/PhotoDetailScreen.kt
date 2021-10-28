package com.sample.photo.feature_photo_impl.navigation

import androidx.fragment.app.Fragment
import com.github.terrakok.modo.android.AppScreen
import com.sample.photo.feature_photo_impl.presentation.PhotoDetailFragment
import kotlinx.parcelize.Parcelize

@Parcelize
class PhotoDetailScreen : AppScreen("PhotoDetailScreen") {
    override fun create(): Fragment {
        return PhotoDetailFragment()
    }
}