package com.example.patomaniaccompose.data.model

import com.google.gson.annotations.SerializedName

data class Recipes(

    val offset: Int,
    val number: Int,
    @SerializedName("resultDataRecipe")
    val result: ArrayList<ResultRecipes>
)

class ResultRecipes(

    val id: Int,
    @SerializedName("titleRecipe")
    val tittle: String,
    val image: String,
    val imageType: String
)
