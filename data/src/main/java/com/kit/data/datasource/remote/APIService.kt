package com.kit.data.datasource.remote

import com.kit.data.util.Constants
import com.kit.domain.dto.CategoryResponseDTO
import com.kit.domain.dto.MealDTO
import com.kit.domain.dto.MealsResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface APIService {

    @GET(Constants.GET_RANDOM_MEAL)
    suspend fun getRandomMeal() : MealsResponseDTO

    @GET(Constants.GET_MEAL_BY_ID)
    suspend fun getMealByID(@Query("i")  id: Int) : MealsResponseDTO

    @GET(Constants.FILTER)
    suspend fun filterMealByCategory(@Query("c")  categoryName: String) : MealsResponseDTO

    @GET(Constants.GET_DETAILED_CATEGORIES)
    suspend fun getCategories() : CategoryResponseDTO


}