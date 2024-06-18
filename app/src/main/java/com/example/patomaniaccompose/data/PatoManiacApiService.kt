package com.example.patomaniaccompose.data

import com.example.patomaniaccompose.data.model.Recipes
import com.example.patomaniaccompose.data.model.ResultSimilarRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface PatoManiacApiService {

    @GET("recipes/complexSearch")       //endpoint
    suspend fun getRecipes(
        @Query("apiKey") apiKey: String = "1546be6d60b141b59478bd7b0825d4be"    //consulta sql
    ): Response<Recipes>

    @GET("recipes/715538/similar")
    suspend fun getSimilarRecipes(
        @Query("apiKey") apiKey: String = "970e015b88144816a92682fcf9be0551"
    ): Response<ArrayList<ResultSimilarRecipe>>
}