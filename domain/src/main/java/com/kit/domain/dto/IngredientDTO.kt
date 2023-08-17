package com.kit.domain.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
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