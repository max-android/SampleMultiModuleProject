package com.sample.memes.feature_memes_impl.navigation

import androidx.fragment.app.Fragment
import com.github.terrakok.modo.android.AppScreen
import com.sample.memes.feature_memes_impl.presentation.MemesFragment
import kotlinx.parcelize.Parcelize

@Parcelize
class MemesScreen : AppScreen("MemesScreen") {
    override fun create(): Fragment {
        return MemesFragment()
    }
}