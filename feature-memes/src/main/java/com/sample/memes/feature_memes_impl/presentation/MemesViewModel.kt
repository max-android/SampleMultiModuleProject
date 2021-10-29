package com.sample.memes.feature_memes_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.modo.forward
import com.sample.memes.feature_memes_impl.data.MemesRepository
import com.sample.memes.feature_memes_impl.di.MemesFeatureComponentHolder
import com.sample.memes.feature_memes_impl.navigation.MemesDetailScreen
import com.sample.navigation.core_nav_impl.Navigator
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MemesViewModel : ViewModel() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    internal lateinit var repository: MemesRepository

    init {
        MemesFeatureComponentHolder.getComponent().inject(this)
    }

    fun showContent() {
        viewModelScope.launch {
            try {
                (repository.loadMemesData() as SuccessMemes).memes.forEach {
                  Timber.tag("--DATA").i("---Memes:"+it.toString())
                }
            } catch (e: Exception) {

            }
        }
    }

    fun clickOnItem() {
        navigator.getRouter().forward(MemesDetailScreen())
    }

    override fun onCleared() {
        super.onCleared()
        MemesFeatureComponentHolder.reset()
    }

}