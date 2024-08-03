package com.example.android_development

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import com.example.android_development.ui.theme.HomeView
import androidx.navigation.compose.composable

@Composable
fun Navigation(viewModel: WishViewModel = viewModel(), navcontroller : NavHostController = rememberNavController()){

   NavHost(navController = navcontroller, startDestination = Screen.HomeScreen.route ) {
       composable(Screen.HomeScreen.route){
           HomeView(navcontroller,viewModel)
       }
       composable(Screen.AddScreen.route){
           AddEditDetailView(id = 0L, viewModel = viewModel(), navController = navcontroller )
       }
   }
}