package com.example.ppm_lab03.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.ppm_lab03.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        var nameLastname by rememberSaveable { mutableStateOf("") }
        var receiver by rememberSaveable { mutableStateOf("") }
        var message by rememberSaveable { mutableStateOf("") }

        var selectedItem by remember { mutableStateOf("Cumpleaños") }
        var isMenuExpanded by remember { mutableStateOf(false) }

        Column {
            OutlinedButton(
                onClick = { isMenuExpanded = true},
                content = { Text(selectedItem)}
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

        TextField(
            value = nameLastname,
            onValueChange = { nameLastname = it},
            label = { Text ("Ingrese su nombre y apellido:") },
            singleLine = true
        )

        TextField(
            value = receiver,
            onValueChange = { receiver = it},
            label = { Text ("A quien va dirigida la carta:") },
            singleLine = true
        )

        TextField(
            value = message,
            onValueChange = { message = it},
            label = { Text ("Mensaje que desea enviar") },
            singleLine = false
        )

        Button(onClick = {
            if(selectedItem == "Cumpleaños"){
                navController.navigate(route = AppScreens.BirthdayCards.route + "/$nameLastname" + "/$message" + "/$receiver")
            }
            else if(selectedItem == "Graduación"){
                navController.navigate(route = AppScreens.GraduationCards.route + "/$nameLastname" + "/$message" + "/$receiver")
            }
            else if(selectedItem == "Año nuevo chino"){
                navController.navigate(route = AppScreens.ChineseNewYearCards.route + "/$nameLastname" + "/$message" + "/$receiver")
            }
            else if(selectedItem == "Día de la madre"){
                navController.navigate(route = AppScreens.MothersDayCards.route + "/$nameLastname" + "/$message" + "/$receiver")
            }
            else if(selectedItem == "Día del padre"){
                navController.navigate(route = AppScreens.FathersDayCards.route + "/$nameLastname" + "/$message" + "/$receiver")

            }
        }) {
            Text(text = "Continuar")
        }
    }
}