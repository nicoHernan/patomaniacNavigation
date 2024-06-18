package com.example.patomaniaccompose.features.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun DetailsScreen (
    navController: NavController,
    id: String?
) {
    Scaffold(
    modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)         
        ) {
            Text(text = "Argumento de navegación ${id}")
        }
    }
}

@Preview (showBackground = true)
@Composable
fun DetailScreenPreview (){
}
