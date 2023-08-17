package com.kit.domain.dto


import com.google.gson.annotations.SerializedName

data class MealResultResponseDTO(
    @SerializedName("meals")
    val mealResultDTOS: List<MealResultDTO?>?
)