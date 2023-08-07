package com.kit.domain.model

import com.kit.domain.dto.MealDTO

data class MealModel(
    val id: String,
    val name: String,
    val category: String,
    val area: String,
    val ingredients: List<IngredientModel?>,
    val imageURL: String?,
    val videoURL: String?,

    )
fun MealDTO.toMealModel() = MealModel(
    name = strMeal ?: "",
    id = idMeal ?: "",
    category = strCategory ?: "",
    area = strArea ?: "",
    imageURL = strMealThumb ?: "",
    videoURL = strYoutube ?: "",
    ingredients = listOf(
        if (strIngredient1.isNullOrBlank()) {
            IngredientModel(strIngredient1 ?: "", strMeasure1 ?: "")
        } else if (strIngredient2.isNullOrBlank()) {
            IngredientModel(strIngredient2 ?: "", strMeasure2 ?: "")
        } else if (strIngredient3.isNullOrBlank()) {
            IngredientModel(strIngredient3 ?: "", strMeasure3 ?: "")
        } else if (strIngredient4.isNullOrBlank()) {
            IngredientModel(strIngredient4 ?: "", strMeasure4 ?: "")
        } else if (strIngredient5.isNullOrBlank()) {
            IngredientModel(strIngredient5 ?: "", strMeasure5 ?: "")
        } else if (strIngredient6.isNullOrBlank()) {
            IngredientModel(strIngredient6 ?: "", strMeasure6 ?: "")
        } else if (strIngredient7.isNullOrBlank()) {
            IngredientModel(strIngredient7 ?: "", strMeasure7 ?: "")
        } else if (strIngredient8.isNullOrBlank()) {
            IngredientModel(strIngredient8 ?: "", strMeasure8 ?: "")
        } else if (strIngredient9.isNullOrBlank()) {
            IngredientModel(strIngredient9 ?: "", strMeasure9 ?: "")
        } else if (strIngredient10.isNullOrBlank()) {
            IngredientModel(strIngredient10 ?: "", strMeasure10 ?: "")
        } else if (strIngredient11.isNullOrBlank()) {
            IngredientModel(strIngredient11 ?: "", strMeasure11 ?: "")
        } else if (strIngredient12.isNullOrBlank()) {
            IngredientModel(strIngredient12 ?: "", strMeasure12 ?: "")
        } else if (strIngredient13.isNullOrBlank()) {
            IngredientModel(strIngredient13 ?: "", strMeasure13 ?: "")
        } else if (strIngredient14.isNullOrBlank()) {
            IngredientModel(strIngredient14 ?: "", strMeasure14 ?: "")
        } else if (strIngredient15.isNullOrBlank()) {
            IngredientModel(strIngredient15 ?: "", strMeasure15 ?: "")
        } else if (strIngredient16.isNullOrBlank()) {
            IngredientModel(strIngredient16 ?: "", strMeasure16 ?: "")
        } else if (strIngredient17.isNullOrBlank()) {
            IngredientModel(strIngredient17 ?: "", strMeasure17 ?: "")
        } else if (strIngredient18.isNullOrBlank()) {
            IngredientModel(strIngredient18 ?: "", strMeasure18 ?: "")
        } else if (strIngredient19.isNullOrBlank()) {
            IngredientModel(strIngredient19 ?: "", strMeasure19 ?: "")
        } else if (strIngredient20.isNullOrBlank()) {
            IngredientModel(strIngredient20 ?: "", strMeasure20 ?: "")
        } else {
            null
        }


    )
)

