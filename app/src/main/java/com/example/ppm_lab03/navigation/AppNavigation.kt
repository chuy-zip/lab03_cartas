package com.example.ppm_lab03.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ppm_lab03.screens.BirthdayCards
import com.example.ppm_lab03.screens.ChineseNewYearCards
import com.example.ppm_lab03.screens.FathersDayCards
import com.example.ppm_lab03.screens.GraduationCards
import com.example.ppm_lab03.screens.InputScreen
import com.example.ppm_lab03.screens.MothersDayCards

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.InputScreen.route){
        composable(route = AppScreens.InputScreen.route){
            InputScreen(navController)
        }
        composable(route = AppScreens.GraduationCards.route + "/{name}" + "/{message}" + "/{receiver}",
            arguments = listOf(
                navArgument(name = "name"){ type = NavType.StringType },
                navArgument(name = "message"){ type = NavType.StringType },
                navArgument(name = "receiver"){type = NavType.StringType}
            )
        ){
            GraduationCards(navController, it.arguments?.getString("name"), it.arguments?.getString("message"),it.arguments?.getString("receiver"))
        }
        composable(route = AppScreens.MothersDayCards.route + "/{name}" + "/{message}" + "/{receiver}",
            arguments = listOf(
                navArgument(name = "name"){ type = NavType.StringType },
                navArgument(name = "message"){ type = NavType.StringType },
                navArgument(name = "receiver"){type = NavType.StringType}
            )
            ){
            MothersDayCards(navController, it.arguments?.getString("name"), it.arguments?.getString("message"),it.arguments?.getString("receiver"))
        }
        composable(route = AppScreens.FathersDayCards.route + "/{name}" + "/{message}" + "/{receiver}",
            arguments = listOf(
                navArgument(name = "name"){ type = NavType.StringType },
                navArgument(name = "message"){ type = NavType.StringType },
                navArgument(name = "receiver"){type = NavType.StringType}
            )
        ){
            FathersDayCards(navController, it.arguments?.getString("name"), it.arguments?.getString("message"),it.arguments?.getString("receiver"))
        }
        composable(route = AppScreens.ChineseNewYearCards.route + "/{name}" + "/{message}" + "/{receiver}",
            arguments = listOf(
                navArgument(name = "name"){ type = NavType.StringType },
                navArgument(name = "message"){ type = NavType.StringType },
                navArgument(name = "receiver"){type = NavType.StringType}
            )
        ){
            ChineseNewYearCards(navController, it.arguments?.getString("name"), it.arguments?.getString("message"),it.arguments?.getString("receiver"))
        }
        composable(route = AppScreens.BirthdayCards.route + "/{name}" + "/{message}" + "/{receiver}",
            arguments = listOf(
                navArgument(name = "name"){ type = NavType.StringType },
                navArgument(name = "message"){ type = NavType.StringType },
                navArgument(name = "receiver"){type = NavType.StringType}
            )
        ){
            BirthdayCards(navController, it.arguments?.getString("name"), it.arguments?.getString("message"),it.arguments?.getString("receiver"))
        }
    }
}