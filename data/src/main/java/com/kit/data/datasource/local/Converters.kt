package com.kit.data.datasource.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.kit.domain.model.IngredientModel


class Converters {
    @TypeConverter
    fun listToJson(value: List<IngredientModel>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<IngredientModel>::class.java).toList()
}