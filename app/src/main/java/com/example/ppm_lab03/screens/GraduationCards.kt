package com.example.ppm_lab03.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ppm_lab03.R

@Composable
fun GraduationCards(navController: NavController, name: String?, message: String?, receiver: String?){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        TopTitle(tittle = "Graduación", navController)

        var currentSelection by remember {mutableStateOf("1")}

        when (currentSelection) {
            "1" -> CustomCard(name, message, receiver, R.drawable.grad1, Color(255, 255, 255))
            "2" -> CustomCard(name, message, receiver, R.drawable.grad2, Color(0, 0, 0))
            "3" -> CustomCard(name, message, receiver, R.drawable.grad3, Color(96, 130, 182))
            "4" -> CustomCard(name, message, receiver, R.drawable.grad4, Color(0, 0, 0))
        }

        BottomBar(currentSelection){newSelection ->
            currentSelection = newSelection
        }

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
                .padding(14.dp)
                .size(56.dp)
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
fun BottomBar(selection: String, onSelectionChange: (String) -> Unit){
    Row( modifier = Modifier
        .fillMaxWidth()
        .height(80.dp),
        horizontalArrangement = Arrangement.SpaceAround){

        Button(
            onClick = {onSelectionChange("1")},
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(51,97,172),
                contentColor = Color.White)) {
            Text(text = "1")
        }
        Button(
            onClick = {onSelectionChange("2")},
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(51,97,172),
                contentColor = Color.White)) {
            Text(text = "2")
        }
        Button(
            onClick = {onSelectionChange("3")},
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(51,97,172),
                contentColor = Color.White)) {
            Text(text = "3")
        }
        Button(
            onClick = {onSelectionChange("4")},
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(51,97,172),
                contentColor = Color.White)) {
            Text(text = "4")
        }

    }
}

@Composable
fun CustomCard(name: String?, message: String?, receiver: String?, intTest: Int, rgbTextColor: Color){

    Box(
        modifier = Modifier
            .height(600.dp)
    ){
        Image(
            painter = painterResource(id = intTest),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(115.dp))
            Text(text = "$name",
                color = rgbTextColor)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "$receiver",
                color = rgbTextColor)

            Spacer(modifier = Modifier.height(70.dp))

            Text(text = "$message",
                color = rgbTextColor,
                fontSize = 24.sp )
        }

    }
}

