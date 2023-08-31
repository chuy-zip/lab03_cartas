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
import com.example.ppm_lab03.R

@Composable
fun ChineseNewYearCards(
    navController: NavController,
    name: String?,
    message: String?,
    receiver: String?
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        TopTitle(tittle = "Año Nuevo Chino", navController)

        var currentSelection by remember { mutableStateOf("1") }

        when (currentSelection) {
            "1" -> CustomCard(name, message, receiver, R.drawable.chinese1, Color(244, 136, 135))
            "2" -> CustomCard(name, message, receiver, R.drawable.chinese2, Color(255, 244, 210))
            "3" -> CustomCard(name, message, receiver, R.drawable.chinese3, Color(93, 201, 248))
            "4" -> CustomCard(name, message, receiver, R.drawable.chinese4, Color(48, 105, 172))

        }
        BottomBar(currentSelection){newSelection -> currentSelection = newSelection }
    }
}