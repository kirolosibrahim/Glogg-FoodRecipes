package com.kit.domain.repository

import com.kit.domain.dto.AreaResponseDTO

interface AreaRepository {

    suspend fun getAreaListFromRemote() : AreaResponseDTO
}