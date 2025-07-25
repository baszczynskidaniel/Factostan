package com.example.factostan.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FactEntity::class],
    version = 1,
)
abstract class FactDatabase: RoomDatabase() {
    abstract val dao: FactDao

}