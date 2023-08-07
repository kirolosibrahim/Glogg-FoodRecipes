package com.kit.foodrecipes.ui.main_layout.screens.home.manager

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kit.domain.usecases.GetHomeCategoriesUseCase
import com.kit.domain.usecases.GetRecipeOfTheDayUseCase
import com.kit.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRecipeOfTheDayUseCase: GetRecipeOfTheDayUseCase,
    private val getHomeCategoriesUseCase: GetHomeCategoriesUseCase
) : ViewModel() {


    var state by mutableStateOf(HomeStateState())
        private set



    init {
        getRecipeOfTheDay()
        getCategories()
    }

    private fun getRecipeOfTheDay() {

        getRecipeOfTheDayUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    state.recipeOfTheDayState = state.recipeOfTheDayState.copy(meal = result.data)
                }

                is Resource.Loading -> {
                    state.recipeOfTheDayState  = state.recipeOfTheDayState.copy(isLoading = true)
                }

                is Resource.Error -> {
                    state.recipeOfTheDayState  = state.recipeOfTheDayState.copy(
                        error = result.message ?: " An unexpected error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }



    private fun getCategories() {

        getHomeCategoriesUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    state.homeCategoriesState = HomeCategoriesState(categories = result.data?: emptyList())
                }

                is Resource.Loading -> {
                    state.homeCategoriesState  = HomeCategoriesState(isLoading = true)
                }

                is Resource.Error -> {
                    state.homeCategoriesState  = HomeCategoriesState(
                        error = result.message ?: " An unexpected error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}

