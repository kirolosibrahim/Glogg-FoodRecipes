package com.kit.domain.dto


import com.google.gson.annotations.SerializedName
import com.kit.domain.model.HomeCategoryModel
import com.kit.domain.model.MealModel

data class CategoryDTO(
    @SerializedName("idCategory")
    val idCategory: String,
    @SerializedName("strCategory")
    val strCategory: String,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String?,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String?
)


fun CategoryDTO.toHomeCategoryModel( mealsList  :List<MealModel>) = HomeCategoryModel(name = strCategory , id = idCategory , meals =mealsList  )