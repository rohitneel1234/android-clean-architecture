package com.rohitneel.androidcleanarchitecture.domain.di

import com.rohitneel.androidcleanarchitecture.domain.repository.ImageRepository
import com.rohitneel.androidcleanarchitecture.domain.use_cases.GetSearchImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
     fun provideGetSearchUseCase(imageRepository: ImageRepository): GetSearchImageUseCase {
         return GetSearchImageUseCase(imageRepository)
     }
}