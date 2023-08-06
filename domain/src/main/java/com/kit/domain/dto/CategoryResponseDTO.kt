package com.kit.domain.dto


import com.google.gson.annotations.SerializedName

data class CategoryResponseDTO(
    @SerializedName("categories")
    val categories: List<CategoryDTO>
)