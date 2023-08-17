package com.kit.domain.usecases

import com.kit.domain.dto.toMealModel
import com.kit.domain.entity.toMealModel
import com.kit.domain.model.MealModel
import com.kit.domain.model.toMealEntity
import com.kit.domain.repository.MealRepository
import com.kit.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetMealByIDUseCase(
    private val repository: MealRepository
) {
    operator fun invoke(id: String): Flow<Resource<MealModel>> = flow {
        try {
            emit(Resource.Loading<MealModel>())
            val _id = id.toInt()
            repository.getMealByIDFromCash(_id)?.let { meal ->
                emit(Resource.Success<MealModel>(meal.toMealModel()))
            } ?: run {
                val mealModel = repository.getMealByIDFromRemote(_id).meals.first().toMealModel()
                repository.insertMealOfTheDay(mealModel.toMealEntity()).let { longID ->


                    repository.getMealByIDFromCash(_id)?.let { meal ->
                        println("inserted id " + _id)
                        emit(Resource.Success<MealModel>(meal.toMealModel()))
                    }

                }
            }

        } catch (e: HttpException) {

            emit(Resource.Error<MealModel>(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException) {
            emit(
                Resource.Error<MealModel>(
                    e.localizedMessage ?: "Couldn't reach server . check your internet connection"
                )
            )

        }


    }
}