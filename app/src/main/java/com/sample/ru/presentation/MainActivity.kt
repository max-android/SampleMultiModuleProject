package com.sample.ru.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.android.ModoRender
import com.github.terrakok.modo.android.init
import com.github.terrakok.modo.newStack
import com.github.terrakok.modo.replace
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sample.memes.feature_memes_impl.navigation.MemesScreen
import com.sample.navigation.core_nav_api.NavigatorApi
import com.sample.news.feature_news_impl.navigation.NewsScreen
import com.sample.photo.feature_photo_impl.navigation.PhotoScreen
import com.sample.ru.R
import com.sample.ru.di.AppComponent
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorApi: NavigatorApi
    private lateinit var router: Modo
    private val viewModel by viewModels<MainViewModel>()
    private val modoRender by lazy { ModoRender(this, R.id.mainContainer) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppComponent.get().inject(this)
        initNavigation(savedInstanceState)
        initViews()
        observeState()
        viewModel.obtainEvent(InitFirstLaunch)
    }

    override fun onResume() {
        super.onResume()
        router.render = modoRender
    }

    override fun onPause() {
        router.render = null
        super.onPause()
    }

    private fun initNavigation(savedInstanceState: Bundle?) {
        router = navigatorApi.navigator().getRouter()
        router.init(savedInstanceState, MemesScreen())
    }

    private fun initViews() {
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navItemMemes -> viewModel.obtainEvent(ShowMemesEvent)
                R.id.navItemNews -> viewModel.obtainEvent(ShowNewsEvent)
                R.id.navItemPhoto -> viewModel.obtainEvent(ShowPhotoEvent)
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
            true
        }
    }

    private fun observeState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect(::renderState)
        }
    }

    private fun renderState(state: MainState?) {
        state?.let {
            when (state) {
                is StartMemesScreen -> router.newStack(MemesScreen())
                is StartNewsScreen -> router.newStack(NewsScreen())
                is StartPhotoScreen -> router.newStack(PhotoScreen())
            }
        }
    }
}