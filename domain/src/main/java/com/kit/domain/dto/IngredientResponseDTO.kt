package com.kit.domain.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class IngredientResponseDTO(
    @SerializedName("meals")
    val ingredients: List<IngredientDTO?>?
)