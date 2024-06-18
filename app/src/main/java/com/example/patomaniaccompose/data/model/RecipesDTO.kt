package com.example.patomaniaccompose.data.model

import com.google.gson.annotations.SerializedName

data class Recipes(

    val offset: Int,
    val number: Int,
    @SerializedName("results")
    val result: ArrayList<ResultRecipes>
)

class ResultRecipes(

    val id: Int,
    @SerializedName("title")
    val tittle: String,
    val image: String,
    val imageType: String
)
