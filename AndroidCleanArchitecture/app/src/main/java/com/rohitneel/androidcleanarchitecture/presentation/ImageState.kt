package com.rohitneel.androidcleanarchitecture.presentation

import com.rohitneel.androidcleanarchitecture.domain.model.ImageModel

data class ImageState(
    val isLoading: Boolean = false,
    val data: List<ImageModel>? = null,
    val error: String = ""
)
