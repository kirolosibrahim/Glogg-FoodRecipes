package com.kit.foodrecipes.ui.main_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kit.foodrecipes.theme.FoodRecipesTheme
import com.kit.foodrecipes.ui.category.CategoryScreen
import com.kit.foodrecipes.ui.category.viewmodel.CategoryViewModel
import com.kit.foodrecipes.ui.details.MealDetailsScreen
import com.kit.foodrecipes.ui.details.viewmodel.MealDetailsViewModel
import com.kit.foodrecipes.ui.main_layout.screens.home.HomeScreen2
import com.kit.foodrecipes.ui.main_layout.screens.home.manager.HomeViewModel
import com.kit.foodrecipes.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalComposeUiApi::class)
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
                    val navController = rememberNavController()
                    NavHost(
                        modifier = Modifier.semantics {
                                                      testTagsAsResourceId = true
                        },
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(Screen.HomeScreen.route) {
                            val viewModel: HomeViewModel = hiltViewModel()
                            HomeScreen2(navController = navController,state =  viewModel.state)
                        }
                        composable(
                            route = Screen.MealDetailsScreen.route + "?id={id}",
                            arguments = listOf(
                                navArgument(name = "id") {
                                    type = NavType.StringType
                                },

                                )
                        ) {
                            val viewModel: MealDetailsViewModel = hiltViewModel()
                            MealDetailsScreen(state = viewModel.state , onEvent = { event->
                                viewModel.onEvent(event)
                            }, navController = navController)
                        }
                        composable(
                            route = Screen.CategoryScreen.route + "?category={category}" + "?image={image}",
                            arguments = listOf(
                                navArgument(name = "category") {
                                    type = NavType.StringType
                                },

                                )
                        ) {
                            val viewModel: CategoryViewModel = hiltViewModel()
                            CategoryScreen(viewModel.state, onEvent = { event ->
                                viewModel.onEvent(event)
                            }, navController = navController)
                        }
                    }

                }
            }
        }
    }
}
