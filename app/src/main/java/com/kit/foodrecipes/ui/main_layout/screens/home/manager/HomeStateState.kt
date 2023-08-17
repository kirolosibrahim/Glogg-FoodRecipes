package com.kit.foodrecipes.ui.main_layout.screens.home.manager

import androidx.compose.runtime.Stable
import com.kit.domain.model.HomeCategoryModel
import com.kit.domain.model.MealModel
@Stable
data class HomeStateState(
    val meal: MealModel? = null,
    val isLoading: Boolean = false,
    val categories: List<HomeCategoryModel>? = emptyList(),
    val error: String = ""
)


