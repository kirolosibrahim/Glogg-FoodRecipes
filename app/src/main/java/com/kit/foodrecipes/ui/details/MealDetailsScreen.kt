package com.kit.foodrecipes.ui.details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kit.foodrecipes.core.YoutubeAlert
import com.kit.foodrecipes.theme.BigCasIonFBBold
import com.kit.foodrecipes.ui.details.components.MealDetailsAppBar
import com.kit.foodrecipes.ui.details.components.MealDetailsHeader
import com.kit.foodrecipes.ui.details.components.MealDetailsIngredientsScreen
import com.kit.foodrecipes.ui.details.components.MealDetailsRecipeScreen
import com.kit.foodrecipes.ui.details.manager.MealDetailsEvent
import com.kit.foodrecipes.ui.details.manager.MealDetailsState

@Composable
fun MealDetailsScreen(state : MealDetailsState, onEvent: (MealDetailsEvent)->Unit,navController: NavHostController) {

    val applicationContext = LocalContext.current


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        state.meal?.let { meal ->


            if (state.isVideoAlertShown) {
                YoutubeAlert(onDismiss = { onEvent(MealDetailsEvent.ShowHideVideoAlert) },
                    onRequestDismiss = { onEvent(MealDetailsEvent.ShowHideVideoAlert) }) {
                     Intent(Intent.ACTION_VIEW).also {
                        it.data = Uri.parse(meal.videoURL)
                        it.`package` = "com.google.android.youtube"
                        applicationContext.startActivity(it)

                    }

                    onEvent(MealDetailsEvent.ShowHideVideoAlert)
                }
            }




            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Box(modifier = Modifier.fillMaxSize()) {


                    MealDetailsHeader(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(600.dp),
                        meal.name, meal.area, meal.category, meal.imageURL!!, meal.videoURL){
                        onEvent(MealDetailsEvent.ShowHideVideoAlert)
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 550.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.White)
                    ) {

                        TabRow(
                            modifier = Modifier.padding(top = 15.dp),
                            selectedTabIndex =  state.tabState,
                            divider = { Divider() },
                            indicator = {},
                        ) {
                            state.tabTitles.forEachIndexed { index, title ->
                                Tab(
                                    selected =  state.tabState == index,
                                    onClick = { onEvent(MealDetailsEvent.ChangeTab(index)) },
                                    text = {
                                        Text(
                                            text = title,
                                            color = if ( state.tabState == index) Color.Black else Color.Gray,
                                            fontSize = 26.sp,
                                            fontFamily = BigCasIonFBBold,
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                )
                            }
                        }

                        if ( state.tabState == 0) {
                            MealDetailsIngredientsScreen(
                                modifier = Modifier.fillMaxSize(),
                                meal.ingredients
                            )
                        } else {
                            MealDetailsRecipeScreen(recipe = meal.recipe)
                        }

                    }
                }
            }

            MealDetailsAppBar(
                modifier = Modifier.background(Color.Transparent),
                meal = meal,
                onFavoriteClick = {
                    onEvent(MealDetailsEvent.ChangeFavorite)
                },
                onNavigationClick = {
                    navController.popBackStack()
                })


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

        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }

}




