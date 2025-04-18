package com.andiniaulia3119.dapurku.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddRecipe : Screen("add_recipe")
    object Detail : Screen("detail/{recipeId}") {
        fun createRoute(recipeId: Long) = "detail/$recipeId"
    }
}
