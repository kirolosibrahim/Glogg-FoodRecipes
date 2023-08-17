package com.kit.domain.usecases


import android.annotation.SuppressLint
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
import java.text.SimpleDateFormat
import java.util.Date


class GetRecipeOfTheDayUseCase(private val repository: MealRepository) {
    @SuppressLint("SimpleDateFormat")
    operator fun invoke(): Flow<Resource<MealModel>> = flow {
        try {
            emit(Resource.Loading<MealModel>())
            val sdf = SimpleDateFormat("dd-MM-yyyy")
            val currentDate = sdf.format(Date())
            if (repository.getMealOfTheDayFromCash(currentDate) != null) {
                val meal = repository.getMealOfTheDayFromCash(currentDate)
                meal?.let {
                    emit(Resource.Success<MealModel>(it.toMealModel()))
                }
            } else {


                val meal = repository.getRandomMealFromRemote().meals.first().toMealModel()
                repository.insertMealOfTheDay(meal.toMealEntity(currentDate))

                emit(Resource.Success<MealModel>(meal))

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