package com.sample.photo.feature_photo_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.sample.network.core_network_impl.data.model.PhotoModel
import com.sample.photo.R
import com.sample.theme.MultiComposeAppTheme
import com.sample.theme.ui.EmptyDetailItemUi
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.ViewWindowInsetObserver

class PhotoDetailFragment : Fragment(R.layout.fragment_photo_detail) {

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
                    val photo = getPhoto()
                    if (photo != null) {
                        PhotoDetailUi(photo)
                    } else {
                        EmptyDetailItemUi()
                    }
                }
            }
        }
    }

    private fun getPhoto(): PhotoModel? = arguments?.getParcelable(PHOTO_KEY) as? PhotoModel

    companion object {
        fun newInstance(photoModel: PhotoModel): Fragment = PhotoDetailFragment().also { frag ->
            frag.arguments = Bundle().also { bundle ->
                bundle.putParcelable(PHOTO_KEY, photoModel)
            }
        }

        private const val PHOTO_KEY = "photo"
    }

}