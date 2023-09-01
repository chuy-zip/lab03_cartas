package com.example.ppm_lab03.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.ppm_lab03.R

@Composable
fun MothersDayCards(navController: NavController, name: String?, message: String?, receiver: String?){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        TopTitle(tittle = "Día de la madre", navController)

        var currentSelection by remember { mutableStateOf("1") }

        when (currentSelection) {
            "1" -> CustomCard(name, message, receiver, R.drawable.mom1, Color(191, 82, 79))
            "2" -> CustomCard(name, message, receiver, R.drawable.mom2, Color(0, 0, 0))
            "3" -> CustomCard(name, message, receiver, R.drawable.mom3, Color(150, 93, 99))
            "4" -> CustomCard(name, message, receiver, R.drawable.mom4, Color(0, 0, 0))

        }

        BottomBar(currentSelection){newSelection -> currentSelection = newSelection }

    }

}

@Preview
@Composable
fun previewtester(){
    CustomCard(name = "Ricardo", message = "Felicidades", receiver = "Andres", intTest = R.drawable.mom3, Color(93, 201, 248))
}