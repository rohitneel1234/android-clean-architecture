package com.rohitneel.androidcleanarchitecture.data.di

import com.rohitneel.androidcleanarchitecture.data.network.ApiService
import com.rohitneel.androidcleanarchitecture.data.network.BASE_URL
import com.rohitneel.androidcleanarchitecture.data.repository.ImageRepositoryImpl
import com.rohitneel.androidcleanarchitecture.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideImageRepo(apiService: ApiService): ImageRepository {
        return ImageRepositoryImpl(apiService)
    }

}