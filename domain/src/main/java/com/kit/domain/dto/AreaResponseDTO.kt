package com.kit.domain.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class AreaResponseDTO(
    @SerializedName("meals")
    val areas: List<AreaDTO?>?
)