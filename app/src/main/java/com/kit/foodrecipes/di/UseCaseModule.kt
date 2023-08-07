package com.kit.foodrecipes.di

import com.kit.domain.repository.CategoryRepository
import com.kit.domain.repository.MealRepository
import com.kit.domain.usecases.GetHomeCategoriesUseCase
import com.kit.domain.usecases.GetRecipeOfTheDayUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {


    @Provides
    fun provideGetRecipeOfTheDayUseCase(mealRepository: MealRepository): GetRecipeOfTheDayUseCase {
        return GetRecipeOfTheDayUseCase(mealRepository)
    }

    @Provides
    fun provideGetHomeCategoryUseCase(categoryRepository: CategoryRepository, mealRepository: MealRepository): GetHomeCategoriesUseCase {
        return GetHomeCategoriesUseCase(categoryRepository, mealRepository)
    }




}