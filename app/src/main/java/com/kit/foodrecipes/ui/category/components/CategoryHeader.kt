package com.kit.foodrecipes.ui.category.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import coil.compose.SubcomposeAsyncImage
import com.kit.foodrecipes.ui.theme.BigCasIonFBBold
import com.kit.foodrecipes.ui.theme.primaryColor


@Composable
fun CategoryHeader(modifier: Modifier, imageURL  :String, name:String, onBackPressed :()->Unit ) {


    Box(modifier = modifier
    ) {
        SubcomposeAsyncImage(
            model = imageURL,
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
                    color = Color.Black.copy(alpha = 0.3f),
                )
        )
        Text(
            modifier = Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(5.dp))
//                .background(color = Color.Black.copy(alpha = 0.4f))
//
//                .padding(8.dp)
                .align(Alignment.BottomStart),
            text = name,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 30.sp,
            fontFamily = BigCasIonFBBold,
            color = Color.White
        )

        IconButton(onClick = {onBackPressed() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back Navigation",
                tint = primaryColor
            )
        }



    }






}