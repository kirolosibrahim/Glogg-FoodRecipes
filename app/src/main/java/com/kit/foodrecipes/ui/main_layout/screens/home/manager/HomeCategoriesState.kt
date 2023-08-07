package com.kit.foodrecipes.ui.main_layout.screens.home.manager

import com.kit.domain.model.HomeCategoryModel

data class HomeCategoriesState(
    val isLoading: Boolean = false,
    val categories: List<HomeCategoryModel>? = null,
    val error: String = ""
)


