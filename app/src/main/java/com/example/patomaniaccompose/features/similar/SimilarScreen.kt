package com.example.patomaniaccompose.features.similar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.patomaniaccompose.data.model.ResultSimilarRecipe
import com.example.patomaniaccompose.navigation.AppScreens

@Composable
fun SimilarScreen (
    navController: NavController,
    similarViewModel: SimilarViewModel= hiltViewModel()
) {

    val similarUiState = similarViewModel.similarUiState.collectAsState()

    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {

            LazyColumn {

                items(similarUiState.value.listSimilarRecipes) {

                    SimilarRecipesItem(itemSimilar = it){
                        navController.navigate(AppScreens.SimilarRecipeScreen.route)
                    }
                }
            }
        }
    }
}

@Composable
fun SimilarRecipesItem(

    itemSimilar: ResultSimilarRecipe,
    itemSimilarSelected: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                itemSimilarSelected(itemSimilar.id.toString())
            }
    ) {

        AsyncImage(
            model = itemSimilar.sourceUrl,
            contentDescription = null
        )
    }
}

