package com.kit.foodrecipes.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.kit.foodrecipes.ui.theme.BigCasIonFBBold
import com.kit.foodrecipes.ui.theme.FuturaPTBook
import com.kit.foodrecipes.ui.theme.primaryColor


@Composable
fun MealDetailsHeader(modifier : Modifier , name  : String , nationality  : String , category  : String,imageURL : String , videoURL : String? , onVideoClick: () ->Unit) {
    Box(modifier =modifier
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
                    color = Color.Black.copy(alpha = 0.6f),
                )
        )
        videoURL?.let{
            CustomPlayButton(modifier = Modifier
                .align(Alignment.Center)
                .size(100.dp)) {
                onVideoClick()
            }
        }


        Column(modifier  = Modifier.padding(bottom = 50.dp)
            .align(Alignment.BottomStart)
            .fillMaxWidth()) {
            Text(modifier = Modifier.padding(start = 20.dp , bottom =20.dp ) , text = name , color = Color.White , fontSize = 40.sp , fontFamily = BigCasIonFBBold)

          Row(modifier = Modifier
              .fillMaxWidth()
              .padding(20.dp) , verticalAlignment = Alignment.CenterVertically) {
              Text(text = "nationality : " , color = Color.Gray , fontSize = 16.sp , fontFamily = FuturaPTBook)
              Text(text = nationality , color = primaryColor , fontSize = 16.sp , fontFamily = FuturaPTBook)
              Spacer(modifier = Modifier.weight(1f))
              Text(text = category , color = primaryColor , fontSize = 16.sp , fontFamily = FuturaPTBook)
          }

        }

    }
}

