package com.kit.domain.model


import com.kit.domain.entity.MealEntity


data class MealModel(
    val id: String,
    val name: String,
    val category: String,
    val area: String,
    val ingredients: List<IngredientModel?>,
    val imageURL: String?,
    val videoURL: String?,
    val isSaved: Boolean = false,
    val isFavorite: Boolean = false,
    val isMealOfTheDay: Boolean = false
)

fun MealModel.toMealEntity(date: String) = MealEntity(
    id = id,
    name = name,
    ingredients = ingredients,
    date = date,
    isFavorite = isFavorite,
    isMealOfTheDay = isMealOfTheDay,
    area = area,
    isSaved = isSaved,
    videoURL = videoURL,
    category = category,
    imageURL = imageURL
)