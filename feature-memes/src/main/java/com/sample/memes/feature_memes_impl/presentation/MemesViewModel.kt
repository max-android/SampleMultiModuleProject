package com.sample.memes.feature_memes_impl.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.modo.forward
import com.sample.memes.feature_memes_impl.di.MemesFeatureComponentHolder
import com.sample.memes.feature_memes_impl.navigation.MemesDetailScreen
import com.sample.navigation.core_nav_impl.Navigator
import javax.inject.Inject

class MemesViewModel: ViewModel() {

    @Inject
    lateinit var navigator: Navigator

    init {
        MemesFeatureComponentHolder.getComponent().inject(this)
    }

    fun clickOnItem() {
        navigator.getRouter().forward(MemesDetailScreen())
    }

    override fun onCleared() {
        super.onCleared()
        MemesFeatureComponentHolder.reset()
    }

}