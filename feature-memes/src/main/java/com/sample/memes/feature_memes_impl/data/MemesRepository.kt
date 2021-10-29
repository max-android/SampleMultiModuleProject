package com.sample.memes.feature_memes_impl.data

import com.sample.memes.feature_memes_impl.di.MemesFeature
import com.sample.memes.feature_memes_impl.presentation.ErrorMemes
import com.sample.memes.feature_memes_impl.presentation.MemesState
import com.sample.memes.feature_memes_impl.presentation.SuccessMemes
import com.sample.network.core_network_impl.data.rest.MemesRestService
import com.sample.network.core_network_impl.data.utils.getBodyDto
import javax.inject.Inject

@MemesFeature
internal class MemesRepository @Inject constructor(private val apiService: MemesRestService) {

    suspend fun loadMemesData(): MemesState {
        return try {
            val memes = apiService.memes()
            SuccessMemes(memes.getBodyDto().memes)
        } catch (throwable: Throwable) {
            ErrorMemes(throwable)
        }
    }

}