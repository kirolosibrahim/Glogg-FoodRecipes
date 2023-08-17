package com.kit.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kit.domain.entity.MealEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {

    @Query("Select * From meals_table where isFavorite")
    fun getFavoriteMeals(): Flow<List<MealEntity>>


    @Query("Select * From meals_table where isSaved")
    fun getSavedMeals(): Flow<List<MealEntity>>

    @Query("Select * From meals_table where isMealOfTheDay and date=:currentDate")
    suspend fun getMealOfTheDay(currentDate:String):MealEntity?


    @Query("Select * From meals_table where id = :id")
    suspend fun getMealByID(id: Int): MealEntity?


    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertMeal(note : MealEntity) : Long

    @Delete
    suspend fun deleteMeal(note: MealEntity)



    @Update
    suspend fun updateMeal(note: MealEntity)

}