package com.example.patomaniaccompose.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import coil.compose.AsyncImage
import com.example.patomaniaccompose.data.model.ResultRecipes

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

    navController: NavController,   //TODO por qué NavController y no NavHostController
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
                .padding(it)
        ) {
            Text(text = "prueba de recetas")

            LazyColumn {

                items(uiState.value.listRecipes) {

                    RecipesItem(item = it) { id ->
                        navController.navigate("details_screen / $id") // Todo -> route igual string que en AppScreen ??
                    }
                }
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "go_to_similarRecipe")
            }
        }

    }
}

@Preview (showBackground = true)
@Composable
fun HomeScreenPreview (){

    HomeScreen()    //Todo Preview ??
}