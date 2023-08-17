package com.kit.domain.usecases

import com.kit.domain.model.MealModel
import com.kit.domain.model.toMealEntity
import com.kit.domain.repository.MealRepository
import com.kit.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AddRemoveFavoriteMealUseCase(
    private val repository: MealRepository
) {
    operator fun invoke(meal: MealModel): Flow<Resource<Boolean>> = flow {
        try {
            repository.updateMealFromCash(meal.toMealEntity()).also {
                emit(Resource.Success<Boolean>(data = !meal.isFavorite))
            }

        } catch (e: Exception) {

            e.localizedMessage?.let { emit(Resource.Error<Boolean>(it)) }
        }
    }
}