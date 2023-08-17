package com.kit.foodrecipes.ui.main_layout.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kit.foodrecipes.theme.BigCasIonFBBold
import com.kit.foodrecipes.theme.primaryColor



@Composable
 fun HomeCategoryHeader(name: String,  onItemClick : ()->Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(5.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.clickable { onItemClick() },
            text = name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 26.sp,
            fontFamily = BigCasIonFBBold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.weight(1F))
        IconButton(onClick = { onItemClick() }) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null,
                tint = primaryColor
            )
        }
    }
}
