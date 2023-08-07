package com.kit.foodrecipes.ui.main_layout.screens.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.kit.domain.model.MealModel
import com.kit.foodrecipes.theme.BigCasIonFBBold
import com.kit.foodrecipes.theme.FuturaPTBook
import com.kit.foodrecipes.theme.primaryColor
import com.kit.foodrecipes.ui.main_layout.screens.home.manager.HomeCategoriesState

import com.kit.foodrecipes.ui.main_layout.screens.home.manager.HomeStateState
import com.kit.foodrecipes.ui.main_layout.screens.home.manager.RecipeOfTheDayState
import com.kit.foodrecipes.utils.Screen

@Composable
fun HomeScreen(
    navController: NavController,
    state : HomeStateState
) {



    Column {
        HeaderSection(state.recipeOfTheDayState, navController)
        CategoriesSection(state.homeCategoriesState, navController)
    }



}

@Composable
private fun HeaderSection(
    state: RecipeOfTheDayState,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .size(350.dp)
            .clip(RoundedCornerShape(15.dp))

    ) {
        state.meal?.let { mealModel ->
            RecipeOfTheDaySection(modifier = Modifier, meal = mealModel) {
                navController.navigate(Screen.MealDetailsScreen.route + "?id=${mealModel.id}")
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
            Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_LONG)
                .show()
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}


@Composable
fun RecipeOfTheDaySection(
    modifier: Modifier = Modifier, meal: MealModel, onItemClick: (MealModel) -> Unit
) {


    Box(modifier = Modifier
        .clickable { onItemClick(meal) }


    ) {
        SubcomposeAsyncImage(
            model = meal.imageURL,
            loading = {
                CircularProgressIndicator()
            },
            modifier = Modifier.fillMaxSize(),
            contentDescription = "",
            contentScale = ContentScale.Crop,

        )
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Black.copy(alpha = 0.4f),
                )
        )
        Text(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(color = Color.Black.copy(alpha = 0.4f))

                .padding(8.dp)
                .align(Alignment.TopEnd),
            text = meal.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp,
            fontFamily = BigCasIonFBBold,
            color = primaryColor
        )

        Text(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .align(Alignment.BottomStart),
            text = "Recipe" + "\n" + "of the day",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 40.sp,
            fontFamily = BigCasIonFBBold,
            color = Color.White
        )

    }
}

@Composable
fun CategoriesSection(state: HomeCategoriesState, navController: NavController) {
   Box(modifier = Modifier.fillMaxWidth() ){
       state.categories?.let {



       }
       state.categories?.let {
           LazyColumn {
               items(it){ category ->
                   CategoryHeaderSection(category.name , category.id)
                   LazyRow {
                       items(category.meals) {
                           CategoryHomeItem(it)
                       }
                   }
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
           Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_LONG)
               .show()
       }

       if (state.isLoading) {
           CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
       }



   }




}

@Composable
fun CategoryHomeItem(meal: MealModel) {


    Column(
        modifier = Modifier
            .size(width = 180.dp, height = 210.dp)
            .padding(8.dp)
    ) {

        SubcomposeAsyncImage(
            model = meal.imageURL?: "",
            loading = {
                CircularProgressIndicator()
            },
            modifier = Modifier   .size(166.dp),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
        Text(
            modifier = Modifier.padding(vertical = 2.dp),
            text = meal.name,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp,
            fontFamily = FuturaPTBook,
            color = Color.Gray

        )
    }
}

@Composable
private fun CategoryHeaderSection(name: String, id: String) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1F),
            text = name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 26.sp,
            fontFamily = BigCasIonFBBold,
            color = Color.Black
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null,
                tint = primaryColor
            )
        }
    }
}

