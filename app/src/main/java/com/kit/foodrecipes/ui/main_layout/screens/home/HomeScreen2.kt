package com.kit.foodrecipes.ui.main_layout.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kit.domain.model.HomeCategoryModel
import com.kit.foodrecipes.ui.main_layout.screens.home.components.CategoryHomeItem
import com.kit.foodrecipes.ui.main_layout.screens.home.components.HomeCategoryHeader
import com.kit.foodrecipes.ui.main_layout.screens.home.components.RecipeOfTheDayItem
import com.kit.foodrecipes.ui.main_layout.screens.home.manager.HomeStateState
import com.kit.foodrecipes.utils.Screen

@Composable
fun HomeScreen2(
    navController: NavController, state: HomeStateState
) {

    var list by remember { mutableStateOf<List<HomeCategoryModel>>(emptyList()) }
    list = state.categories ?: emptyList()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, bottom = 16.dp)
    ) {

        if (!state.isLoading) {


            LazyColumn(
                modifier = Modifier.fillMaxSize().testTag("item_list")
            ) {
                state.meal?.let { mealModel ->
                    item {
                        RecipeOfTheDayItem(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .size(350.dp)
                                .clip(RoundedCornerShape(15.dp)), meal = mealModel
                        ) {
                            navController.navigate(Screen.MealDetailsScreen.route + "?id=${mealModel.id}")
                        }
                    }

                }
                state.categories?.let { list ->
                    items(count = list.size, key = { category -> list[category].id } , itemContent = {category->
                        HomeCategoryHeader(list[category].name) {
                            navController.navigate(Screen.CategoryScreen.route + "?category=${list[category].name}" + "?image=${list[category].image}")
                        }
                        LazyRow {
                            items(items = list[category].meals, key = { meal -> meal.id }) { meal ->
                                CategoryHomeItem(meal) { id ->
                                    navController.navigate(Screen.MealDetailsScreen.route + "?id=${id}")
                                }
                            }
                        }
                    })
                }
            }


        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )
            Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_LONG).show()
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}
