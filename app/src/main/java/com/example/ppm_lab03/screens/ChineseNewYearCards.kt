package com.example.ppm_lab03.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.ppm_lab03.R

@Composable
fun ChineseNewYearCards(navController: NavController, name: String?, message: String?, receiver: String?){

    var userCard = "1"

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        TopTitle(tittle = "Año nuevo chino", navController)

        var currentSelection by remember { mutableStateOf("1") }

        Column {
            when (currentSelection) {
                "1" -> CustomCard(name, message, receiver, 1)
                "2" -> CustomCard(name, message, receiver, 2)
                "3" -> CustomCard(name, message, receiver, 3)
                "4" -> CustomCard(name, message, receiver, 4)
            }
            userCard = currentSelection
        }

        BottomBar(currentSelection){newSelection -> 
            currentSelection = newSelection 
        }
    }
    ChineseLayout(pickedCard = userCard)
}

@Composable
fun ChineseLayout(pickedCard: String) {
    when (pickedCard) {
        "1" -> {
            Image(painter = painterResource(id = R.drawable.chinese1),
                contentDescription = "First Chinese Card.")
        }

        "2" -> {
            Image(painter = painterResource(id = R.drawable.chinese2),
                contentDescription = "Second Chinese Card.")
        }

        "3" -> {
            Image(painter = painterResource(id = R.drawable.chinese3),
                contentDescription = "Third Chinese Card.")
        }

        "4" -> {
            Image(painter = painterResource(id = R.drawable.chinese4),
                contentDescription = "Fourth Chinese Card.")
        }
    }

}

@Preview
@Composable
fun ChinesePreview() {
    ChineseLayout("1")
}