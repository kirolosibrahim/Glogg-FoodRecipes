package com.kit.foodrecipes.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kit.foodrecipes.R

@Composable
fun CustomPlayButton(modifier: Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(Color.Transparent)

            .clip(CircleShape)
            .border(1.dp, Color.White, CircleShape).clickable {
            onClick()
        }

    ) {
        Icon(
            modifier = Modifier
                .size(40.dp)
                .padding(start = 7.dp)
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.ic_play),
            tint = Color.White,
            contentDescription = "Play video Button"
        )
    }
}