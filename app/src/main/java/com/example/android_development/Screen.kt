package com.example.android_development

sealed class Screen(val route:String) {
    object HomeScreen : Screen("Home_Screen")
    object AddScreen : Screen("Add_Screen")
}