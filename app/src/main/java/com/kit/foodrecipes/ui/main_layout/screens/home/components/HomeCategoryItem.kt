package com.kit.foodrecipes.ui.main_layout.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage

import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.kit.domain.model.MealModel
import com.kit.foodrecipes.ui.theme.FuturaPTBook

@Composable
fun CategoryHomeItem(meal: MealModel , onItemClick : (String)->Unit) {


    Column(
        modifier = Modifier.width(150.dp).padding(end = 8.dp).clickable {onItemClick(meal.id)  }
    ) {

        SubcomposeAsyncImage(
            loading = {
                CircularProgressIndicator()
            },
            model = meal.imageURL ?: "",
            modifier = Modifier.size(150.dp).clip(RoundedCornerShape(15.dp)),
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