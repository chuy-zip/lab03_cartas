package com.example.ppm_lab03.navigation

sealed class AppScreens (val route: String){
    object GraduationCards: AppScreens("grad_screen")
    object MothersDayCards: AppScreens("mother_screen")
    object InputScreen: AppScreens("input_screen")
    object FathersDayCards: AppScreens("father_route")
    object ChineseNewYearCards: AppScreens("chinese_route")
    object BirthdayCards: AppScreens("birthday_route")
}
