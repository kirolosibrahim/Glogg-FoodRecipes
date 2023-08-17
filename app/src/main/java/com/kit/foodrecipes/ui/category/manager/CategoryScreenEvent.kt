package com.kit.foodrecipes.ui.category.manager

sealed class CategoryScreenEvent{

     data class ChangeMealsLayout(val isColumn : Boolean) : CategoryScreenEvent()
}
