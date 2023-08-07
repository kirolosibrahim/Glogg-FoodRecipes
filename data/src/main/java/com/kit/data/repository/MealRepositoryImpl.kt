package com.kit.data.repository

import com.kit.data.datasource.remote.APIService
import com.kit.domain.dto.MealDTO
import com.kit.domain.dto.MealsResponseDTO
import com.kit.domain.repository.MealRepository
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(private val apiService: APIService) : MealRepository {


    override suspend fun getMealByIDFromRemote(id: Int): MealsResponseDTO {
        return apiService.getMealByID(id)
    }

    override suspend fun getMealByCategoryName(categoryName: String): MealsResponseDTO {
      return  apiService.filterMealByCategory(categoryName)
    }

    override suspend fun getRandomMealFromRemote(): MealsResponseDTO {
        return apiService.getRandomMeal()
    }

}