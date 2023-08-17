package com.kit.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.kit.domain.entity.MealEntity

@Database(
    entities = [MealEntity::class], version = 5, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RoomDB : RoomDatabase() {


    abstract val dao: Dao

    companion object {
        const val DATABASE_Name = "meals_db"
    }
}