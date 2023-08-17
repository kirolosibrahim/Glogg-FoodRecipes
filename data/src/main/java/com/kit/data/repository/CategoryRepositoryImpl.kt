package com.kit.data.repository

import androidx.annotation.Keep
import com.kit.data.datasource.remote.APIService
import com.kit.domain.dto.CategoryResponseDTO
import com.kit.domain.dto.MealDTO
import com.kit.domain.dto.MealsResponseDTO
import com.kit.domain.repository.CategoryRepository
import com.kit.domain.repository.MealRepository
import javax.inject.Inject
@Keep
class CategoryRepositoryImpl @Inject constructor(private val apiService: APIService) : CategoryRepository {
    override suspend fun getCategoriesFromRemote(): CategoryResponseDTO {
        return apiService.getCategories()
    }


}