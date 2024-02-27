package com.rohitneel.androidcleanarchitecture.domain.use_cases

import com.rohitneel.androidcleanarchitecture.common.Resource
import com.rohitneel.androidcleanarchitecture.domain.model.ImageModel
import com.rohitneel.androidcleanarchitecture.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSearchImageUseCase(private val imageRepository: ImageRepository) {

    operator fun invoke(query: String): Flow<Resource<List<ImageModel>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = imageRepository.getSearchResults(query) ))
        } catch (e: java.lang.Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}