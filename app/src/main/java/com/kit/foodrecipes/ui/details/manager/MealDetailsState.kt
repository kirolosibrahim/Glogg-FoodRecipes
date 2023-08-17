package com.kit.foodrecipes.ui.details.manager

import com.kit.domain.model.MealModel

data class MealDetailsState(

    val meal: MealModel? = null,
    val isLoading: Boolean = false,
    val error: String = "",
    val isVideoAlertShown: Boolean = false,
    val tabTitles: List<String> = listOf("Ingredients", "Recipe"),
    val tabState: Int = 0

)
