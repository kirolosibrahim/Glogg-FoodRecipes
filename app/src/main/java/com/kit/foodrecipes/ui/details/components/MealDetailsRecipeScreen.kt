package com.kit.foodrecipes.ui.details.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kit.foodrecipes.ui.theme.FuturaPTBook

@Composable
fun MealDetailsRecipeScreen(recipe: String) {
    Text(
        modifier = Modifier.fillMaxSize().padding(15.dp),
        text = recipe,
        fontFamily = FuturaPTBook,
        fontSize = 16.sp,
        color = Color.Black
    )
}