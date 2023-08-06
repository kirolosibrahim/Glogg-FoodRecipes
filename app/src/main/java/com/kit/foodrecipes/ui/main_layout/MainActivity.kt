package com.kit.foodrecipes.ui.main_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kit.foodrecipes.theme.FoodRecipesTheme

import com.kit.foodrecipes.ui.main_layout.screens.home.HomeScreen
import com.kit.foodrecipes.ui.main_layout.screens.home.manager.HomeViewModel
import com.kit.foodrecipes.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: HomeViewModel = hiltViewModel()

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(Screen.HomeScreen.route) {
                            HomeScreen(navController = navController , viewModel.state)
                        }
                        composable(route = Screen.MealDetailsScreen.route + "?id={id}",
                            arguments = listOf(
                                navArgument(name = "id") {
                                    type = NavType.StringType
                                },

                            )
                        ) {
                         //   HomeScreen(navController = navController)
                        }
                    }

                }
            }
        }
    }
}
