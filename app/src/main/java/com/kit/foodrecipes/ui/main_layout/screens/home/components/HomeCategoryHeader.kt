package com.kit.foodrecipes.ui.main_layout.screens.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.kit.foodrecipes.theme.BigCasIonFBBold
import com.kit.foodrecipes.theme.primaryColor



@Composable
 fun HomeCategoryHeader(name: String, id: String) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1F),
            text = name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 26.sp,
            fontFamily = BigCasIonFBBold,
            color = Color.Black
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null,
                tint = primaryColor
            )
        }
    }
}
