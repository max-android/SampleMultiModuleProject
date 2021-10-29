package com.sample.ru.presentation

import androidx.lifecycle.ViewModel
import com.sample.core.EventHandler
import com.sample.ru.di.AppComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel(), EventHandler<MainEvent> {

    private val _state = MutableStateFlow<MainState?>(null)
    val state: StateFlow<MainState?> = _state.asStateFlow()

    override fun obtainEvent(event: MainEvent) {
        when (event) {
            is InitFirstLaunch -> initFirstLaunchAction()
            is ShowMemesEvent -> initMemesFeatureAction()
            is ShowPhotoEvent -> initPhotoFeatureAction()
            is ShowNewsEvent -> initNewsFeatureAction()
        }
    }

    private fun initFirstLaunchAction() {
        AppComponent.get().plusMemesFeatureApi()
    }

    private fun initMemesFeatureAction() {
        AppComponent.get().plusMemesFeatureApi()
        _state.value = StartMemesScreen
    }

    private fun initPhotoFeatureAction() {
        AppComponent.get().plusPhotoFeatureApi()
        _state.value = StartPhotoScreen
    }

    private fun initNewsFeatureAction() {
        AppComponent.get().plusNewsFeatureApi()
        _state.value = StartNewsScreen
    }
}