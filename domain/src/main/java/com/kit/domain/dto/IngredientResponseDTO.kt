package com.kit.domain.dto


import com.google.gson.annotations.SerializedName

data class IngredientResponseDTO(
    @SerializedName("meals")
    val ingredients: List<IngredientDTO?>?
)