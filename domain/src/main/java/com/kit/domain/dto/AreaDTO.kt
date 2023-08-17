package com.kit.domain.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class AreaDTO(
    @SerializedName("strArea")
    val strArea: String?
)