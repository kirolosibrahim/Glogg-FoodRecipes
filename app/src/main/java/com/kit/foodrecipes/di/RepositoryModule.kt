package com.kit.foodrecipes.di


import com.kit.data.datasource.remote.APIService
import com.kit.data.repository.CategoryRepositoryImpl
import com.kit.data.repository.MealRepositoryImpl
import com.kit.domain.repository.CategoryRepository
import com.kit.domain.repository.MealRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMealRepository(apiService: APIService): MealRepository {
        return MealRepositoryImpl(apiService)
    }



    @Provides
    fun provideCategoryRepository(apiService: APIService): CategoryRepository {
        return CategoryRepositoryImpl(apiService)
    }


}