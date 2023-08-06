package com.kit.domain.repository

import com.kit.domain.dto.MealsResponseDTO

interface MealRepository {


    suspend fun getMealByIDFromRemote(id : Int) : MealsResponseDTO
    suspend fun getMealByCategoryName(categoryName  : String) : MealsResponseDTO
    suspend fun getRandomMealFromRemote() : MealsResponseDTO
}