package com.neudesic.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.neudesic.myapplication.ui.screen.UserListScreen
import com.neudesic.myapplication.ui.screen.home.HomeScreen
import com.neudesic.myapplication.ui.screen.home.HomeViewModel

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            // ref: https://developer.android.com/training/dependency-injection/hilt-jetpack#viewmodel-navigation
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(vm = viewModel)
        }
        composable("team") {
            UserListScreen()
        }
    }
}