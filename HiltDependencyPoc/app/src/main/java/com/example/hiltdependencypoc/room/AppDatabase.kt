package com.example.hiltdependencypoc.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BlogCacheEntity::class ], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun blogDao(): BlogDao

    companion object{
        val DATABASE_NAME: String = "test_db"
    }
}