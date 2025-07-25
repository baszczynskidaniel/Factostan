package com.example.factostan.core.database.di

import android.app.Application
import androidx.room.Room
import com.example.factostan.core.database.FactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideFactDatabase(app: Application): FactDatabase {
        return Room.databaseBuilder(
            app,
            FactDatabase::class.java,
            "fact_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideFactDao(db: FactDatabase) = db.dao
}
