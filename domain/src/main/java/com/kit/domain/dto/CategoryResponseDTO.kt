package com.kit.domain.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class CategoryResponseDTO(
    @SerializedName("categories")
    val categories: List<CategoryDTO>
)