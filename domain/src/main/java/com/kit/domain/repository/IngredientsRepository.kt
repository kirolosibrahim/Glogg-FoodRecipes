package com.kit.domain.repository

import com.kit.domain.dto.AreaResponseDTO
import com.kit.domain.dto.IngredientResponseDTO

interface IngredientsRepository {

    suspend fun getIngredientListFromRemote() : IngredientResponseDTO
}