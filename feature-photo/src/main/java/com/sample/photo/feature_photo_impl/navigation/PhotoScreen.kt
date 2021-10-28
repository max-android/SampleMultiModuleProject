package com.sample.photo.feature_photo_impl.navigation

import androidx.fragment.app.Fragment
import com.github.terrakok.modo.android.AppScreen
import com.sample.photo.feature_photo_impl.presentation.PhotoFragment
import kotlinx.parcelize.Parcelize

@Parcelize
class PhotoScreen : AppScreen("PhotoScreen") {
    override fun create(): Fragment {
        return PhotoFragment()
    }
}