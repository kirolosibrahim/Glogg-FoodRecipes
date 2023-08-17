package com.kit.foodrecipes.ui.category.manager

import com.kit.domain.model.MealModel

data class CategoryScreenState (
    val meals : List<MealModel>? = emptyList(),
    val isLoading : Boolean = true,
    val isColumn : Boolean = true,
    val error: String = "",
    val category: String = "",
    val categoryImage: String = "",
)