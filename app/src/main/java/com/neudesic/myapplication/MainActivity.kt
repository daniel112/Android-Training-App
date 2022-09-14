package com.neudesic.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.neudesic.myapplication.navigation.AppBar
import com.neudesic.myapplication.navigation.DrawerBody
import com.neudesic.myapplication.navigation.DrawerHeader
import com.neudesic.myapplication.navigation.MenuItem
import com.neudesic.myapplication.ui.theme.TrainingAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingAppTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                // A surface container using the 'background' color from the theme
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            onNavigationIconClick = {
                                scope.launch{
                                    scaffoldState.drawerState.open()

                                }
                            }
                        )
                    },
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(items = listOf(
                            MenuItem(
                                id = "Noah",
                                title = "Noah's page",
                                contentDescription = "Noah's page",
                                icon = Icons.Default.Home
                            ),
                            MenuItem(
                                id = "Karen",
                                title = "Karen's page",
                                contentDescription = "Karen's page",
                                icon = Icons.Default.Home
                            ),
                            MenuItem(
                                id = "Lauren",
                                title = "Lauren's page",
                                contentDescription = "Lauren's page",
                                icon = Icons.Default.Home
                            ),
                            MenuItem(
                                id = "Daniel",
                                title = "Daniel's page",
                                contentDescription = "Daniel's page",
                                icon = Icons.Default.Home
                            ),
                        ), onItemClick = {
                            println("Clicked on ${it.title}")
                        })
                    }
                ) {
                    
                }
            }
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    TrainingAppTheme {
//        Greeting("Android")
//    }
//}