package com.kit.domain.model

import androidx.annotation.Keep

@Keep
data class HomeCategoryModel (
    val name : String ,
    val id : String ,
    val image : String ,
    val meals : List<MealModel>
)