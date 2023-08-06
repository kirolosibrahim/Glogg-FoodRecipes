package com.kit.domain.repository

import com.kit.domain.dto.CategoryResponseDTO

interface CategoryRepository {

    suspend fun getCategoriesFromRemote() : CategoryResponseDTO
}