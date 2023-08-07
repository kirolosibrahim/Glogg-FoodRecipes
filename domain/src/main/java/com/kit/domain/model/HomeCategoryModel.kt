package com.kit.domain.model

data class HomeCategoryModel (
    val name : String ,
    val id : String ,
    val meals : List<MealModel>
)