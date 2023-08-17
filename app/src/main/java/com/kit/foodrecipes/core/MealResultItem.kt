package com.kit.foodrecipes.core

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.kit.foodrecipes.theme.BigCasIonFBBold

@Composable
fun MealResultItem(
    modifier: Modifier,
    isColumn: Boolean,
    name: String,
    imageURL: String?,
    id: String,
    onItemClick: (String) -> Unit
) {
    if (isColumn) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp)
                .shadow(elevation = 15.dp)
                .background(Color.White)
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable { onItemClick(id) }
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
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(10.dp),
                text = name,
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = BigCasIonFBBold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )

        }

    } else {

        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.White)
                .padding(15.dp)
                .clickable { onItemClick(id) },
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Box()
            {

                SubcomposeAsyncImage(
                    model = imageURL,
                    loading = {
                        CircularProgressIndicator()
                    },
                    filterQuality = FilterQuality.Low,
                    modifier = Modifier.height(150.dp),
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
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .padding(10.dp),
                    text = name,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = BigCasIonFBBold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )

            }

        }


    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MealResultItemColumnPreview() {
    LazyColumn() {
        items(20) {
            MealResultItem(Modifier, true, "Name " + it, "", "") {}
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MealResultItemGridPreview() {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(20) {
            MealResultItem(Modifier, false, "Name " + it, "", "") {}
        }
    }

}