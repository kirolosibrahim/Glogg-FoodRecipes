package com.kit.foodrecipes.ui.main_layout.screens.home.manager

import com.kit.domain.model.MealModel
import com.kit.domain.dto.MealDTO

data class RecipeOfTheDayState(
    val isLoading: Boolean = false,
    val meal: MealModel? = null,
    val error: String = ""
)


