package com.kit.foodrecipes.ui.details.manager

sealed class MealDetailsEvent{
     data class ChangeTab(val index : Int): MealDetailsEvent()
     object ChangeFavorite : MealDetailsEvent()
     object ShowHideVideoAlert : MealDetailsEvent()
}
