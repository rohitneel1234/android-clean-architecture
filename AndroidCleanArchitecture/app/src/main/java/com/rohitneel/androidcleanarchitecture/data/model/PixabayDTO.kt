package com.rohitneel.androidcleanarchitecture.data.model

data class PixabayDTO(
    val hits: List<HitDTO>,
    val total: Int,
    val totalHits: Int
)