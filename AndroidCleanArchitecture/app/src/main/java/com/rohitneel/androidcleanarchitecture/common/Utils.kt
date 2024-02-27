package com.rohitneel.androidcleanarchitecture.common

import com.rohitneel.androidcleanarchitecture.data.model.HitDTO
import com.rohitneel.androidcleanarchitecture.domain.model.ImageModel

fun HitDTO.toDomainModel(): ImageModel {
    return ImageModel(
        imageUrl = this.previewURL
    )
}