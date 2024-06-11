package com.example.patomaniaccompose.data.model

import com.google.gson.annotations.SerializedName

data class SimilarRecipesDTO(

    val resultSimilarRecipe: ArrayList<ResultSimilarRecipe>
)

class ResultSimilarRecipe(


    @SerializedName("idSimilar")
    val id: Int,

    @SerializedName("titleSimilar")
    val title: String,

    val imageType: String,
    val readyInMinutes: Int,
    val servings: Int,

    @SerializedName("sourceUrlSimilar")
    val sourceUrl: String
)
