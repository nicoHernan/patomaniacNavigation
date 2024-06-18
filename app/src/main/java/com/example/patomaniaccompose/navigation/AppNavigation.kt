package com.example.patomaniaccompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.patomaniaccompose.features.details.DetailsScreen
import com.example.patomaniaccompose.features.home.HomeScreen
import com.example.patomaniaccompose.features.similar.SimilarScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(

        navController = navController,
        startDestination = AppScreens.HomeScreen.route
    ) {

        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(route = AppScreens.DetailsScreen.route) {backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            DetailsScreen(navController, id)
        }

        composable(route = AppScreens.SimilarRecipeScreen.route){

            SimilarScreen(navController)
        }
    }
}