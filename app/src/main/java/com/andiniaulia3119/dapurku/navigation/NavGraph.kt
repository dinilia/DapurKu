package com.andiniaulia3119.dapurku.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.andiniaulia3119.dapurku.ui.screen.AddRecipeScreen
import com.andiniaulia3119.dapurku.ui.screen.DetailScreen
import com.andiniaulia3119.dapurku.ui.screen.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.AddRecipe.route) {
            AddRecipeScreen(navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("recipeId") { type = androidx.navigation.NavType.LongType })
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getLong("recipeId") ?: 0L
            DetailScreen(navController, recipeId)
        }
    }
}
