package com.kit.domain.usecases

import com.kit.domain.dto.toHomeCategoryModel
import com.kit.domain.model.HomeCategoryModel
import com.kit.domain.model.MealModel
import com.kit.domain.model.toMealModel
import com.kit.domain.repository.CategoryRepository
import com.kit.domain.repository.MealRepository
import com.kit.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetHomeCategoriesUseCase(
    private val categoryRepository: CategoryRepository, private val mealRepository: MealRepository
) {

    operator fun invoke(): Flow<Resource<List<HomeCategoryModel>>> = flow {
        try {
            emit(Resource.Loading<List<HomeCategoryModel>>())

            val homeCategoryModel = categoryRepository.getCategoriesFromRemote().categories.let { categoriesDTO->

                categoriesDTO.map {categoryDTO->
                    categoryDTO.toHomeCategoryModel(mealRepository.getMealByCategoryName(categoryDTO.strCategory).meals.map {
                        it.toMealModel()
                    })
                }

            }


println(homeCategoryModel.first().meals.toString())
println(homeCategoryModel.first().name.toString())
            emit(Resource.Success<List<HomeCategoryModel>>(homeCategoryModel))

        } catch (e: HttpException) {

            emit(
                Resource.Error<List<HomeCategoryModel>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )

        } catch (e: IOException) {
            emit(
                Resource.Error<List<HomeCategoryModel>>(
                    e.localizedMessage ?: "Couldn't reach server . check your internet connection"
                )
            )

        }
    }
}