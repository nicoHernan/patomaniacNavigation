package com.example.patomaniaccompose.data

import com.example.patomaniaccompose.data.model.ResultRecipes
import com.example.patomaniaccompose.data.model.ResultSimilarRecipe
import javax.inject.Inject

class PatoManiacRepository @Inject constructor(

    private val patoManiacApiService: PatoManiacApiService
) {

    suspend fun getRecipesInformation(): ArrayList <ResultRecipes> ? {
        return patoManiacApiService.getRecipes().body()?.result
    }

    suspend fun getRecipesSimilarInformation(): ArrayList <ResultSimilarRecipe> ? {
        return patoManiacApiService.getSimilarRecipes().body()
    }
}