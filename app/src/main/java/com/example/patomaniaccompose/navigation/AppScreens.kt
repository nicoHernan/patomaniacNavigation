package com.example.patomaniaccompose.navigation

sealed class AppScreens(val route: String) {

    object HomeScreen : AppScreens("home_screen")
    object DetailsScreen : AppScreens("details_screen/{id}") {
        fun createRoute(id: String): String {
            return "details_screen/${id}"
        }
    }
    object SimilarRecipeScreen: AppScreens("similar_screen")
}