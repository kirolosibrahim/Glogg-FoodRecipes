package com.kit.domain.usecases


import com.kit.domain.model.MealModel
import com.kit.domain.model.toMealModel
import com.kit.domain.repository.MealRepository
import com.kit.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class GetRecipeOfTheDayUseCase(private val repository: MealRepository) {
    operator fun invoke(): Flow<Resource<MealModel>> = flow {
        try {
            emit(Resource.Loading<MealModel>())
            val meal = repository.getRandomMealFromRemote().meals.first().toMealModel()
            println("meal "+ meal.toString())
            emit(Resource.Success<MealModel>(meal))

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