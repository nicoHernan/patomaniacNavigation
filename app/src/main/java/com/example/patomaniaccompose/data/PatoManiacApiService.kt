package com.example.patomaniaccompose.data

import com.example.patomaniaccompose.data.model.Recipes
import com.example.patomaniaccompose.data.model.SimilarRecipesDTO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// @InstallIn(Applicationcomponent::class)  Todo->  acá va InstallIn???
@Module
interface PatoManiacApiService {

    @Provides
    @GET("recipes/complexSearch")       //endpoint
    suspend fun getRecipes(
        @Query("apiKey") apiKey: String = "970e015b88144816a92682fcf9be0551"    //consulta sql

    ): Response <Recipes>   //Response DTO

    @Provides
    @GET("recipes/715538/similar")
    suspend fun getSimilarRecipes(

        @Query("apiKey") apiKey: String = "970e015b88144816a92682fcf9be0551"
    ): Response <SimilarRecipesDTO>
}