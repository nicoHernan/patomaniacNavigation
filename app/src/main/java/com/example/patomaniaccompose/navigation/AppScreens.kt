package com.example.patomaniaccompose.navigation

sealed class AppScreens(val route: String) {

    object HomeScreen : AppScreens("home_screen")
    object DetailsScreen : AppScreens("details_screen")
    object SimilarRecipeScreen: AppScreens("similar_screen")
}