package com.kit.domain.usecases

import com.kit.domain.dto.toMealModel
import com.kit.domain.model.MealModel

import com.kit.domain.repository.MealRepository
import com.kit.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetMealsByCategoryNameUseCase(
    private val repository: MealRepository
) {
    operator fun invoke(category: String): Flow<Resource<List<MealModel>>> = flow {
        try {
            val resultList =
                repository.getMealByCategoryName(category).meals.let { list ->
                    list.map {
                        it.toMealModel()
                    }
                }

            emit(Resource.Success<List<MealModel>>(resultList))
        } catch (e: HttpException) {

            emit(Resource.Error<List<MealModel>>(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException) {
            emit(
                Resource.Error<List<MealModel>>(
                    e.localizedMessage ?: "Couldn't reach server . check your internet connection"
                )
            )

        }


    }
}