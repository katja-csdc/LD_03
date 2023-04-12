package com.example.lectureexamples.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lectureexamples.screens.DetailScreen
import com.example.lectureexamples.screens.HomeScreen

@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "homescreen"
    ) {
        composable("homescreen") { HomeScreen(navController) }
        composable(
            "detailscreen/{movieId}",
            arguments = listOf(navArgument("movieId") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            DetailScreen(navController, movieId = backStackEntry.arguments?.getString("movieId") ?: "")
        }
    }
}