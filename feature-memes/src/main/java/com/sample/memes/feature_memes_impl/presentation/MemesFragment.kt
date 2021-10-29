package com.sample.memes.feature_memes_impl.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sample.memes.R

class MemesFragment: Fragment(R.layout.fragment_memes) {

    private val viewModel by viewModels<MemesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showContent()
        view.findViewById<Button>(R.id.showDetailMemButton).setOnClickListener {
            viewModel.clickOnItem()
        }
    }

}