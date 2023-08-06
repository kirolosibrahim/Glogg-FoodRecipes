package com.kit.domain.dto


import com.google.gson.annotations.SerializedName

data class CategoryDTO(
    @SerializedName("idCategory")
    val idCategory: String?,
    @SerializedName("strCategory")
    val strCategory: String?,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String?,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String?
)