package com.sample.memes.feature_memes_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.sample.memes.R
import com.sample.network.core_network_impl.data.model.MemModel
import com.sample.theme.MultiComposeAppTheme
import com.sample.theme.ui.EmptyDetailItemUi
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.ViewWindowInsetObserver

class MemesDetailFragment : Fragment(R.layout.fragment_memes_detail) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val windowInsets = ViewWindowInsetObserver(this).start()
        setContent {
            CompositionLocalProvider(LocalWindowInsets provides windowInsets) {
                MultiComposeAppTheme {
                    val mem = getMem()
                    if (mem != null) {
                        MemUi(mem)
                    } else {
                        EmptyDetailItemUi()
                    }
                }
            }
        }
    }

    private fun getMem(): MemModel? = arguments?.getParcelable(MEMES_KEY) as? MemModel

    companion object {
        fun newInstance(memeModel: MemModel): Fragment = MemesDetailFragment().also { frag ->
            frag.arguments = Bundle().also { bundle ->
                bundle.putParcelable(MEMES_KEY, memeModel)
            }
        }

        private const val MEMES_KEY = "mem"
    }
}