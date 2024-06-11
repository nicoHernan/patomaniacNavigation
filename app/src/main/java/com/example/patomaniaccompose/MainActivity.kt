package com.example.patomaniaccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.patomaniaccompose.navigation.AppNavigation
import com.example.patomaniaccompose.ui.theme.PatoManiacComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()          // TODO QUE ES ???

        setContent {
            PatoManiacComposeTheme {
                Scaffold (

                    modifier = Modifier
                ) {
                    Column (

                        modifier = Modifier
                            .padding(it)
                    ) {

                        AppNavigation()
                    }
                }
                //Scaffold(modifier = Modifier.fillMaxSize() ) { innerPadding ->   //TODO innerPading ??
                //Todo Scaffold deprecado ??? ->    Captura de pantalla en escritorio del error
                    /*Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ){}                         //Todo -> Colum agregado por innerPadding corresponde ???
*/
            }
        }
    }
}