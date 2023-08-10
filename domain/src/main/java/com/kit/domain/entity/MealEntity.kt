package com.kit.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

import com.kit.domain.model.IngredientModel
import com.kit.domain.model.MealModel

@Entity(tableName = "meals_table")
data class MealEntity(

    @PrimaryKey
    val id: String,
    val name: String,
    val category: String,
    val area: String,
    val ingredients: List<IngredientModel?>,
    val imageURL: String?,
    val videoURL: String?,
    val isSaved: Boolean = false,
    val isFavorite: Boolean = false,
    val isMealOfTheDay: Boolean = false,
    val date: String
)
fun MealEntity.toMealModel() = MealModel(

    id = id,
    name = name,
ingredients =ingredients,
    isFavorite = isFavorite,
    isMealOfTheDay = isMealOfTheDay,
    area = area,
    isSaved = isSaved,
    videoURL = videoURL,
    category = category,
    imageURL = imageURL
)