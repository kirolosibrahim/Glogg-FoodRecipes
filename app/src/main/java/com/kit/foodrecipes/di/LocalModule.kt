package com.kit.foodrecipes.di


import com.kit.data.datasource.local.Converters
import android.app.Application
import androidx.room.Room

import com.kit.data.datasource.local.Dao
import com.kit.data.datasource.local.RoomDB

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {


    @Provides
    @Singleton
    fun provideNoteDatabase(application: Application) : Dao {
        return Room.databaseBuilder(
            application,
            RoomDB::class.java,
            RoomDB.DATABASE_Name,

        ).fallbackToDestructiveMigration().build().dao
    }
}