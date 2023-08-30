package com.example.ppm_lab03.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ppm_lab03.navigation.AppScreens

@Composable
fun GraduationCards(navController: NavController, name: String?, message: String?, receiver: String?){

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopTitle(tittle = "Graduacion", navController)
        BodyContent(navController)

        Text(text = "$name \n $message \n $receiver")

    }

}

@Composable
fun TopTitle(tittle: String, navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth() // Make the Box span the width of the screen
            .background(Color(51, 97, 172)), // Set background color for the Box
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow back",
            modifier = Modifier
                .size(48.dp)
                .clickable {
                    navController.popBackStack()
                }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = tittle,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,

            modifier = Modifier
                .padding(16.dp)
                .height(60.dp)
        )

    }
}

@Composable
fun BodyContent(navController: NavController){
    Column(){
        Text("Prueba de navegacion")
        Button(onClick = {
            navController.navigate(route = AppScreens.MothersDayCards.route)
        } ){
            Text(text = "Navegar...")
        }
    }
}