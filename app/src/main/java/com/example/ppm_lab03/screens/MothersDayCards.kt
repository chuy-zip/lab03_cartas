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
import androidx.navigation.NavController

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
            "1" -> CustomCard(name, message, receiver, 1, Color(5,5,5))
            "2" -> CustomCard(name, message, receiver, 2, Color(5,5,5))
            "3" -> CustomCard(name, message, receiver, 3, Color(5,5,5))
            "4" -> CustomCard(name, message, receiver, 4, Color(5,5,5))

        }

        BottomBar(currentSelection){newSelection -> currentSelection = newSelection }

    }

}

