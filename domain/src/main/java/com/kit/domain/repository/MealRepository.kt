package com.kit.domain.repository

import com.kit.domain.dto.MealsResponseDTO
import com.kit.domain.entity.MealEntity


interface MealRepository {

    suspend fun getMealByIDFromRemote(id: Int): MealsResponseDTO

    suspend fun getMealByCategoryName(categoryName: String): MealsResponseDTO
    suspend fun getRandomMealFromRemote(): MealsResponseDTO

    suspend fun insertMealOfTheDay(meal: MealEntity) : Long

    suspend fun getMealOfTheDayFromCash(currentDate: String):MealEntity?


    suspend fun getMealByIDFromCash(id: Int): MealEntity?
    suspend fun updateMealFromCash(meal: MealEntity)


}