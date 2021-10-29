package com.sample.memes.feature_memes_impl.presentation

import com.sample.network.core_network_impl.data.model.MemModel

sealed class MemesState
object LoadingMemes: MemesState()
class SuccessMemes(
    val memes: List<MemModel>
): MemesState()
class ErrorMemes(val error: Throwable): MemesState()