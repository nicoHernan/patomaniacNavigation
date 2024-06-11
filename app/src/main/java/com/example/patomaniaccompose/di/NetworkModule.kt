package com.example.patomaniaccompose.di

import com.example.patomaniaccompose.data.PatoManiacApiService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module                 //no puede ser inyectado con "Inject" porque Retrofit es una libería externa
@InstallIn (SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

    @Provides
    fun providesPatoManiacApiService (retrofit: Retrofit): PatoManiacApiService =

        retrofit.create(PatoManiacApiService::class.java)
}