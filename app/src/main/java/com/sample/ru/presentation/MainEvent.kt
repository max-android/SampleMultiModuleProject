package com.sample.ru.presentation

sealed interface MainEvent
object InitFirstLaunch: MainEvent
object ShowMemesEvent : MainEvent
object ShowPhotoEvent : MainEvent
object ShowNewsEvent : MainEvent