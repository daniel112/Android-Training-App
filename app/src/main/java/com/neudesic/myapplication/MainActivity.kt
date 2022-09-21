package com.neudesic.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.neudesic.myapplication.ui.navigation.BottomNavigation
import com.neudesic.myapplication.ui.navigation.MainNavigationGraph

import com.neudesic.myapplication.ui.theme.TrainingAppTheme
import dagger.hilt.android.AndroidEntryPoint

//To make an Android class supported by Dagger-HILT we use
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingAppTheme {
                App()
            }
        }
    }
}

/**
 * Compose the root App with bottom navigation
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomNavigation(navController = navController) }) {
        MainNavigationGraph(navController = navController)
    }
}
