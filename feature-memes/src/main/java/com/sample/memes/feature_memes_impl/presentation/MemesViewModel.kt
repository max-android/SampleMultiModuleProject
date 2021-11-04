package com.sample.memes.feature_memes_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.modo.forward
import com.sample.memes.feature_memes_impl.data.MemesRepository
import com.sample.memes.feature_memes_impl.di.MemesFeatureComponentHolder
import com.sample.memes.feature_memes_impl.navigation.MemesDetailScreen
import com.sample.navigation.core_nav_impl.Navigator
import com.sample.network.core_network_impl.data.model.MemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MemesViewModel : ViewModel() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    internal lateinit var repository: MemesRepository

    private val _state = MutableStateFlow<MemesState?>(null)
    val state: StateFlow<MemesState?> = _state.asStateFlow()

    init {
        MemesFeatureComponentHolder.getComponent().inject(this)
        showContent()
    }

    private fun showContent() {
        viewModelScope.launch {
            _state.emit(repository.loadMemesData())
        }
    }

    fun clickOnItem(memeModel: MemModel) {
        navigator.getRouter().forward(MemesDetailScreen(memeModel))
    }

    override fun onCleared() {
        super.onCleared()
        MemesFeatureComponentHolder.reset()
    }

}