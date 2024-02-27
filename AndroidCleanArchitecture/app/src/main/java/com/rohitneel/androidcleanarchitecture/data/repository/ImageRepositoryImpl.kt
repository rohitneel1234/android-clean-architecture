package com.rohitneel.androidcleanarchitecture.data.repository

import com.rohitneel.androidcleanarchitecture.common.toDomainModel
import com.rohitneel.androidcleanarchitecture.data.network.ApiService
import com.rohitneel.androidcleanarchitecture.domain.model.ImageModel
import com.rohitneel.androidcleanarchitecture.domain.repository.ImageRepository
import java.lang.Exception

class ImageRepositoryImpl(private val apiService: ApiService): ImageRepository {
    override suspend fun getSearchResults(query: String): List<ImageModel> {
        try {
            return apiService.getSearchImage(
                key = "Your_Key",
                query = query
            ).hits.map { it.toDomainModel() }
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
}