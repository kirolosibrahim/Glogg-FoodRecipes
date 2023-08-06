package com.kit.domain.dto


import com.google.gson.annotations.SerializedName

data class IngredientDTO(
    @SerializedName("idIngredient")
    val idIngredient: String?,
    @SerializedName("strDescription")
    val strDescription: String?,
    @SerializedName("strIngredient")
    val strIngredient: String?,
    @SerializedName("strType")
    val strType: String?
)