package com.kit.domain.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class MealsResponseDTO(
    @SerializedName("meals")
    val meals: List<MealDTO>
)