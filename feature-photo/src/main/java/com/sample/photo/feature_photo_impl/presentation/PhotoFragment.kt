package com.sample.photo.feature_photo_impl.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sample.photo.R

class PhotoFragment : Fragment(R.layout.fragment_photo) {

    private val viewModel by viewModels<PhotoViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showContent()
        view.findViewById<Button>(R.id.showPhotoDetailButton).setOnClickListener {
            viewModel.clickOnItem()
        }
    }
}