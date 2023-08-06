package com.kit.domain.dto


import com.google.gson.annotations.SerializedName

data class AreaResponseDTO(
    @SerializedName("meals")
    val areas: List<AreaDTO?>?
)