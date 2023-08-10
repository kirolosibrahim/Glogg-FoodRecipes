package com.kit.data.repository

import com.kit.data.datasource.local.Dao
import com.kit.data.datasource.remote.APIService
import com.kit.domain.dto.MealsResponseDTO
import com.kit.domain.entity.MealEntity
import com.kit.domain.repository.MealRepository

import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(private val apiService: APIService ,   private val dao:Dao) : MealRepository {


    override suspend fun getMealByIDFromRemote(id: Int): MealsResponseDTO {
        return apiService.getMealByID(id)
    }

    override suspend fun getMealByCategoryName(categoryName: String): MealsResponseDTO {
      return  apiService.filterMealByCategory(categoryName)
    }

    override suspend fun getRandomMealFromRemote(): MealsResponseDTO {
        return apiService.getRandomMeal()
    }

    override suspend fun insertMealOfTheDay(meal: MealEntity) {
        dao.insertMeal(meal.copy(isMealOfTheDay = true))
    }

    override suspend fun getMealOfTheDay(currentDate: String): MealEntity? {
     return  dao.getMealOfTheDay(currentDate)
    }

}