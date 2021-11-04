package com.sample.memes.feature_memes_impl.navigation

import androidx.fragment.app.Fragment
import com.github.terrakok.modo.android.AppScreen
import com.sample.memes.feature_memes_impl.presentation.MemesDetailFragment
import com.sample.network.core_network_impl.data.model.MemModel
import kotlinx.parcelize.Parcelize

@Parcelize
class MemesDetailScreen(private val memeModel: MemModel): AppScreen("MemesDetailScreen") {
    override fun create(): Fragment {
        return MemesDetailFragment.newInstance(memeModel)
    }
}