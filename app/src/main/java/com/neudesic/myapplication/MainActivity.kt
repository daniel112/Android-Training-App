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

val items = listOf(
    Screen.Home,
    Screen.List,
)



/**
 * All values in sealed class are known at compile time -https://kotlinlang.org/docs/sealed-classes.html
 * similar to enums
 */
sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : Screen("home", R.string.screen_home, Icons.Filled.Home)
    object List : Screen("list", R.string.list_view, Icons.Filled.Face)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrainingAppTheme {
        App()
    }
}