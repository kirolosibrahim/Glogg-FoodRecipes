package com.kit.foodrecipes.ui.category

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kit.domain.model.MealModel
import com.kit.foodrecipes.core.MealResultItem
import com.kit.foodrecipes.ui.theme.primaryColor
import com.kit.foodrecipes.ui.category.components.CategoryHeader
import com.kit.foodrecipes.ui.category.manager.CategoryScreenEvent
import com.kit.foodrecipes.ui.category.manager.CategoryScreenState
import com.kit.foodrecipes.utils.Screen

@Composable
fun CategoryScreen(state : CategoryScreenState , onEvent:(CategoryScreenEvent)->Unit,navController: NavController) {



    Box(modifier = Modifier.fillMaxSize()) {

        if (!state.isLoading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {

                CategoryHeader(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                bottomEnd = 15.dp,
                                bottomStart = 15.dp
                            )
                        )
                        .fillMaxWidth()
                        .height(250.dp), name = state.category, imageURL = state.categoryImage
                ) {
                    navController.popBackStack()
                }
                TabRow(
                    modifier = Modifier.padding(top = 15.dp),
                    selectedTabIndex = if (state.isColumn) 0 else 1,
                    divider = { Divider() },
                    indicator = {},
                ) {
                    Tab(
                        selected = state.isColumn,
                        icon = {
                            Icon(
                                Icons.Default.List,
                                tint = if (state.isColumn) primaryColor else Color.Gray,
                                contentDescription = "") }, onClick = { onEvent(CategoryScreenEvent.ChangeMealsLayout(true)) },
                    )
                    Tab(
                        selected = !state.isColumn,
                        icon = { Icon(
                                Icons.Default.GridView,
                                tint = if (!state.isColumn) primaryColor else Color.Gray,
                                contentDescription = "")
                        },
                        onClick = {onEvent(CategoryScreenEvent.ChangeMealsLayout(false)) },
                    )

                }
                state.meals?.let { list ->
                    if (state.isColumn) {

                        list.forEach { meal ->
                            MealResultItem(Modifier, true, meal.name, meal.imageURL, meal.id) {
                                navController.navigate(Screen.MealDetailsScreen.route + "?id=${meal.id}")
                            }
                        }

                    } else {


                        LazyGridFor<MealModel>(
                            items = list,
                            rowSize = 3,
                            itemContent = { meal ->
                                MealResultItem(Modifier, false, meal.name, meal.imageURL, meal.id) {
                                    navController.navigate(Screen.MealDetailsScreen.route + "?id=${meal.id}")
                                }
                            })


                    }
                }
            }
        } else { CircularProgressIndicator(modifier = Modifier.align(Alignment.Center)) }
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
        }


    }
}

@Composable
fun <T> LazyGridFor(
    items: List<T>,
    rowSize: Int = 1,
    itemContent: @Composable BoxScope.(T) -> Unit,
) {
    items.chunked(rowSize).forEach { row ->
        Row(Modifier.fillMaxWidth()) {
            for ((index, item) in row.withIndex()) {
                Box(Modifier.fillMaxWidth(1f / (rowSize - index))) {
                    itemContent(item)
                }
            }
        }

    }
}
