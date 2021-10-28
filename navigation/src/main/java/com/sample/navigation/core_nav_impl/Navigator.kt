package com.sample.navigation.core_nav_impl

import android.content.Context
import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.android.AppReducer

class Navigator {

    private lateinit var router: Modo

    fun initRouter(context: Context) {
        router = Modo(AppReducer(context))
    }

    fun getRouter() = router
}