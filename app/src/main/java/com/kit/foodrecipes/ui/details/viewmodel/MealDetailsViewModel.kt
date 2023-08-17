package com.kit.foodrecipes.ui.details.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kit.domain.usecases.AddRemoveFavoriteMealUseCase
import com.kit.domain.usecases.GetMealByIDUseCase
import com.kit.domain.utils.Resource
import com.kit.foodrecipes.ui.details.manager.MealDetailsEvent
import com.kit.foodrecipes.ui.details.manager.MealDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val addRemoveFavoriteMealUseCase: AddRemoveFavoriteMealUseCase,
    private val getMealByIDUseCase: GetMealByIDUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(MealDetailsState())


    init {
        getMealByID()
    }

    private fun getMealByID() {
        savedStateHandle.get<String>("id")?.let { id ->
            getMealByIDUseCase.invoke(id).onEach { result ->
                state = when (result) {
                    is Resource.Error -> {
                        MealDetailsState(
                            error = result.message ?: " An unexpected error occurred",
                            isLoading = false
                        )
                    }

                    is Resource.Loading -> {
                        MealDetailsState(isLoading = true)
                    }

                    is Resource.Success -> {
                        MealDetailsState(
                            isLoading = false,
                            error = "",
                            meal = result.data,
                        )
                    }
                }


            }.launchIn(viewModelScope)


        }
    }

    fun onEvent(event: MealDetailsEvent) {
        when (event) {
            is MealDetailsEvent.ChangeFavorite -> {
                val meal = state.meal!!.copy(isFavorite = !state.meal!!.isFavorite)
                addRemoveFavoriteMealUseCase.invoke(meal).onEach { result ->
                    when (result) {
                        is Resource.Error -> {
                            MealDetailsState(
                                error = result.message ?: " An unexpected error occurred",
                                isLoading = false
                            )
                        }

                        is Resource.Loading -> {

                        }

                        is Resource.Success -> {
                            state = state.copy(
                             meal = meal

                            )
                        }
                    }
                }.launchIn(viewModelScope)


            }

            is MealDetailsEvent.ChangeTab -> {
                viewModelScope.launch {
                    state =state.copy(
                        tabState =  event.index
                    )
                }

            }

            MealDetailsEvent.ShowHideVideoAlert -> {
                viewModelScope.launch {
                   state =  state.copy(
                       isVideoAlertShown = !state.isVideoAlertShown
                   )

                }

            }
        }
    }
}

