package com.neudesic.myapplication.navigation


//import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource


@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    // can't import material TopAppBar?
    // when importing material3 TopAppBar having issues with materil 3 iconbuttons
//    TopAppBar(
//        title = {
//            Text(text = stringResource(id = R.string.app_name))
//        }
//    )
}