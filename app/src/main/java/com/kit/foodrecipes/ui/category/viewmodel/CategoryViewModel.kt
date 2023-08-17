package com.kit.foodrecipes.ui.category.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kit.domain.usecases.GetMealsByCategoryNameUseCase
import com.kit.domain.utils.Resource
import com.kit.foodrecipes.ui.category.manager.CategoryScreenEvent
import com.kit.foodrecipes.ui.category.manager.CategoryScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCase: GetMealsByCategoryNameUseCase
) : ViewModel() {


    var state by mutableStateOf(CategoryScreenState())
        private set

    init {
        val category = savedStateHandle.get<String>("category")
        val image = savedStateHandle.get<String>("image")
        viewModelScope.launch {
            state = state.copy(
                category = category ?: "",
                categoryImage = image ?: "",
                isColumn = true
            )
        }
        category?.let {
            getMeals(it)
        }

    }

    private fun getMeals(category: String) {
        useCase.invoke(category).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    state = state.copy(
                        error = result.message ?: " An unexpected error occurred",
                        isLoading = false
                    )

                }

                is Resource.Loading -> {
                    state = state.copy(
                        isLoading = true
                    )

                }

                is Resource.Success -> {
                    state = state.copy(
                        meals = result.data?.sortedBy { it.name } ?: emptyList(),
                        isLoading = false,

                        )

                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: CategoryScreenEvent) {
        when (event) {


            is CategoryScreenEvent.ChangeMealsLayout -> {
                viewModelScope.launch{
                    state = state.copy(
                        isColumn = event.isColumn

                    )
                }

            }
        }
    }


}