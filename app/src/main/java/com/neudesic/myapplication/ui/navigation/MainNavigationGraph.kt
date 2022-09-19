package com.neudesic.myapplication.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.neudesic.myapplication.R
import com.neudesic.myapplication.ui.screen.UserListScreen
import com.neudesic.myapplication.ui.screen.home.HomeScreen
import com.neudesic.myapplication.ui.screen.home.HomeViewModel

/**
 * All values in sealed class are known at compile time -https://kotlinlang.org/docs/sealed-classes.html
 * similar to enums
 */
sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : Screen("home", R.string.screen_home, Icons.Filled.Home)
    object List : Screen("team", R.string.list_view, Icons.Filled.Face)
}

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            // ref: https://developer.android.com/training/dependency-injection/hilt-jetpack#viewmodel-navigation
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(vm = viewModel)
        }
        composable(Screen.List.route) {
            UserListScreen()
        }
    }
}