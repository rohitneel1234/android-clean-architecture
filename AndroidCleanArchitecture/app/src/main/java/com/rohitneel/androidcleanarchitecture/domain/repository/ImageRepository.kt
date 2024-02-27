package com.rohitneel.androidcleanarchitecture.domain.repository

import com.rohitneel.androidcleanarchitecture.domain.model.ImageModel

interface ImageRepository {

    suspend fun getSearchResults(query: String): List<ImageModel>

}