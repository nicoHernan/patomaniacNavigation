package com.example.patomaniaccompose.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.patomaniaccompose.data.model.ResultRecipes
import com.example.patomaniaccompose.navigation.AppScreens
import okhttp3.Route

@Composable
fun RecipesItem(
    item: ResultRecipes,
    itemSelected: (String) -> Unit
) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                itemSelected(item.id.toString())
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(

            text = item.tittle,
            fontSize = 15.sp,
            fontStyle = FontStyle.Normal
        )

        AsyncImage(

            model = item.image,
            contentDescription = null
        )
    }
}


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val uiState = homeViewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(it)
        ) {
            Text(text = "prueba de recetas")

            LazyColumn(
                Modifier.height(800.dp)
            ) {

                items(uiState.value.listRecipes) {

                    RecipesItem(item = it) { id ->
                        navController.navigate(AppScreens.DetailsScreen.createRoute(id))
                    }
                }
            }

            Button(onClick = {
                navController.navigate(AppScreens.SimilarRecipeScreen.route)
            }) {
                Text(text = "go to similarRecipe")
            }
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun RecipesItemPreview() {
    val list = listOf(
        ResultRecipes(
            1,"Title","https://img.spoonacular.com/recipes/715415-312x231.jpg",""
        ),
        ResultRecipes(
            1,"Title 2","https://img.spoonacular.com/recipes/715415-312x231.jpg",""
        )
    )
    Scaffold(

        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(

            modifier = Modifier
                .padding(it)
        ) {
            Text(
                text = "prueba de recetas",
                fontSize = 20.sp
            )

            LazyColumn {

                items(list) {

                    RecipesItem(item = it) { id ->
                    }
                }
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "go_to_similarRecipe")
            }
        }
    }
}