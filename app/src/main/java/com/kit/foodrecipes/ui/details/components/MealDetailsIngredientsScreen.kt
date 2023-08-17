package com.kit.foodrecipes.ui.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.kit.domain.model.IngredientModel
import com.kit.foodrecipes.ui.theme.FuturaPTBook
import com.kit.foodrecipes.ui.theme.primaryColor

@Composable
fun MealDetailsIngredientsScreen(modifier: Modifier, ingredients: List<IngredientModel?>) {


    Column(modifier = modifier.fillMaxWidth()) {
       ingredients.forEach { ingredient ->
           ingredient?.let {
               println(it.imageURL)
               Row(modifier =  Modifier.padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                   SubcomposeAsyncImage(
                       loading = {
                           CircularProgressIndicator()
                       }, model = it.imageURL,
                       modifier = Modifier
                           .size(100.dp)
                           .clip(CircleShape),
                       contentDescription = "",
                       contentScale = ContentScale.Crop,
                   )
                   Text(
                       text = it.ingredient,
                       color = Color.Black,
                       fontFamily = FuturaPTBook,
                       fontSize = 16.sp,
                     modifier =   Modifier.padding(horizontal = 10.dp).weight(1f)
                   )
                   Text(
                       text = it.measure,
                       color = primaryColor,
                       fontFamily = FuturaPTBook,
                       fontSize = 16.sp,
                   )
               }
               Divider()
           }
          

        }
    }

}