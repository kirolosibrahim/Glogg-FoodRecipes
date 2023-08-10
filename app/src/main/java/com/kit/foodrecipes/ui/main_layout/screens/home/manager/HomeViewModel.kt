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

        getCategories()
        getRecipeOfTheDay()


    }

    private fun getRecipeOfTheDay() {

        getRecipeOfTheDayUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    state = state.copy(meal = result.data,
                        isLoading = true)
                }

                is Resource.Loading -> {

                }

                is Resource.Error -> {
                    state = state.copy(
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
                    state = state.copy(
                        categories = result.data ?: emptyList(),
                        isLoading = false
                    )
                }

                is Resource.Loading -> {
                    state = state.copy(isLoading = true)

                }

                is Resource.Error -> {
                    state = state.copy(
                        error = result.message ?: " An unexpected error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}

