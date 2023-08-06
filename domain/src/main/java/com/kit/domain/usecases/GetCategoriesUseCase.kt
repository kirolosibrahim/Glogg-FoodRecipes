package com.kit.domain.usecases

import com.kit.domain.repository.CategoryRepository

class GetCategoriesUseCase(private val categoryRepository: CategoryRepository) {

    suspend operator fun invoke() = categoryRepository.getCategoriesFromRemote()
}