package com.kit.domain.dto


import com.google.gson.annotations.SerializedName

data class MealsResponseDTO(
    @SerializedName("meals")
    val meals: List<MealDTO>
)