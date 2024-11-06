package com.neecs.spotifyclonecompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.neecs.spotifyclonecompose.ui.screens.DetailScreen
import com.neecs.spotifyclonecompose.ui.screens.MainScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") { MainScreen(navController) }
        composable("detail_screen") { DetailScreen() }
    }
}
