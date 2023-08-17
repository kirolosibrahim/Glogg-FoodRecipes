package com.kit.foodrecipes.ui.details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kit.domain.model.MealModel
import com.kit.foodrecipes.theme.primaryColor
import com.kit.foodrecipes.ui.details.manager.MealDetailsState

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun MealDetailsAppBar(
    modifier: Modifier,
 
    onNavigationClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    meal: MealModel
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically){

        IconButton(onClick = { onNavigationClick() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back Navigation",
                tint = primaryColor
            )
        }

Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { onFavoriteClick() }) {
            Icon(
                imageVector = if (meal.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                tint = Color.White,
                contentDescription = "Add Remove Favorite"
            )
        }


    }
        
    
    


}
