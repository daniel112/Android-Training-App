package com.neudesic.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.neudesic.myapplication.ui.screens.HomeScreen
import com.neudesic.myapplication.ui.screens.UserListScreen

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("team") {
            UserListScreen()
        }
    }
}