package com.sample.ru.presentation

sealed interface MainState
object StartMemesScreen: MainState
object StartNewsScreen: MainState
object StartPhotoScreen: MainState