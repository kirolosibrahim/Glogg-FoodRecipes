package com.kit.foodrecipes.utils

sealed class Screen(
    val route : String

){
    object HomeScreen : Screen("home_screen")
    object MealDetailsScreen : Screen("meal_details_screen")
    object CategoryScreen : Screen("category_screen")
}
