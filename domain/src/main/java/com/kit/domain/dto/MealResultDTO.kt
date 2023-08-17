package com.kit.domain.dto


import com.google.gson.annotations.SerializedName
import com.kit.domain.model.MealResultModel

data class MealResultDTO(
    @SerializedName("idMeal")
    val idMeal: String?,
    @SerializedName("strMeal")
    val strMeal: String?,
    @SerializedName("strMealThumb")
    val strMealThumb: String?
)


fun MealResultDTO.toMealResultModel() = MealResultModel(
    name = strMeal,
    image = strMealThumb, id = idMeal

)