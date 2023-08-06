package com.kit.domain.repository

import com.kit.domain.dto.MealDTO
import com.kit.domain.dto.MealsResponseDTO

interface MealRepository {

    suspend fun getMealsFromRemote() : MealsResponseDTO
    suspend fun getMealByIDFromRemote() : MealDTO
    suspend fun getRandomMealFromRemote() : MealDTO
}