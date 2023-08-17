package com.kit.foodrecipes.ui.main_layout.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

import com.kit.domain.model.MealModel
import com.kit.foodrecipes.ui.theme.BigCasIonFBBold
import com.kit.foodrecipes.ui.theme.primaryColor

@Composable
fun RecipeOfTheDayItem(
    modifier: Modifier = Modifier, meal: MealModel, onItemClick: (MealModel) -> Unit
) {
    Box(modifier = modifier.clickable { onItemClick(meal) }
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
