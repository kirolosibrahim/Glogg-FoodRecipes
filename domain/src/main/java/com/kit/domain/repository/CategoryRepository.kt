package com.kit.domain.repository

import androidx.annotation.Keep
import com.kit.domain.dto.CategoryResponseDTO
@Keep
interface CategoryRepository {

    suspend fun getCategoriesFromRemote() : CategoryResponseDTO
}