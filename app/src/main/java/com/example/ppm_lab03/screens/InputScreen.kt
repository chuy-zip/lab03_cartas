package com.example.ppm_lab03.screens

import android.util.DisplayMetrics
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ppm_lab03.R
import com.example.ppm_lab03.navigation.AppNavigation
import com.example.ppm_lab03.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(navController: NavController){

    Image(painter = painterResource(id = R.drawable.loginscreenlayout), contentDescription = "Background Image.",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop)

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){

        var nameLastname by rememberSaveable { mutableStateOf("") }
        var receiver by rememberSaveable { mutableStateOf("") }
        var message by rememberSaveable { mutableStateOf("") }

        DisplayMetrics()
        val screenHeight = with(LocalDensity.current) {
            LocalContext.current.resources.displayMetrics.heightPixels.toDp()
        }

        var selectedItem by remember { mutableStateOf("Cumpleaños") }
        var isMenuExpanded by remember { mutableStateOf(false) }

        Spacer(modifier = Modifier.height(screenHeight / 2))

        TextField(
            value = nameLastname,
            onValueChange = { nameLastname = it},
            label = { Text ("Remitente") },
            singleLine = true,
            shape = CircleShape,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                containerColor = Color(0xff8f8e8e),
                unfocusedLabelColor = Color.White
            )
        )

        TextField(
            value = receiver,
            onValueChange = { receiver = it},
            label = { Text ("Destinatario") },
            singleLine = true,
            shape = CircleShape,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                containerColor = Color(0xff8f8e8e),
                unfocusedLabelColor = Color.White
            )
        )

        TextField(
            value = message,
            onValueChange = { message = it},
            label = { Text ("Mensaje") },
            singleLine = false,
            shape = CircleShape,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                containerColor = Color(0xff8f8e8e),
                unfocusedLabelColor = Color.White
            )
        )

        Column {
            Button(
                onClick = { isMenuExpanded = true},
                content = { Text(selectedItem)},
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff8f8e8e),

                    )
            )
            DropdownMenu(
                expanded = isMenuExpanded,
                onDismissRequest = { isMenuExpanded = false }
            ) {

                DropdownMenuItem(
                    text = { Text("Cumpleaños")},
                    onClick = {
                        selectedItem = "Cumpleaños"
                        isMenuExpanded = false
                    }
                )

                DropdownMenuItem(
                    text = { Text("Graduación")},
                    onClick = {
                        selectedItem = "Graduación"
                        isMenuExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("Año nuevo chino")},
                    onClick = {
                        selectedItem = "Año nuevo chino"
                        isMenuExpanded = false
                    })

                DropdownMenuItem(
                    text = {Text("Día de la madre")},
                    onClick = {
                        selectedItem = "Día de la madre"
                        isMenuExpanded = false
                    })
                DropdownMenuItem(
                    text = {Text("Día del padre")},
                    onClick = {
                        selectedItem = "Día del padre"
                        isMenuExpanded = false
                    }
                )

            }
        }

        Button(
            modifier = Modifier
                .width(280.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffff5757)
            ),
            onClick = {
                when (selectedItem) {
                    "Cumpleaños" -> {
                        navController.navigate(route = AppScreens.BirthdayCards.route + "/$nameLastname" + "/$message" + "/$receiver")
                    }
                    "Graduación" -> {
                        navController.navigate(route = AppScreens.GraduationCards.route + "/$nameLastname" + "/$message" + "/$receiver")
                    }
                    "Año nuevo chino" -> {
                        navController.navigate(route = AppScreens.ChineseNewYearCards.route + "/$nameLastname" + "/$message" + "/$receiver")
                    }
                    "Día de la madre" -> {
                        navController.navigate(route = AppScreens.MothersDayCards.route + "/$nameLastname" + "/$message" + "/$receiver")
                    }
                    "Día del padre" -> {
                        navController.navigate(route = AppScreens.FathersDayCards.route + "/$nameLastname" + "/$message" + "/$receiver")
                    }
                }
                
        }) {
            Text(text = "Continuar")

        }
    }
}

@Preview
@Composable
fun InputPreview() {
    AppNavigation()
}