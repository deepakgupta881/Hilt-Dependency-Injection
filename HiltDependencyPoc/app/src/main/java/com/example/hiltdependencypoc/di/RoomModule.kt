package com.example.hiltdependencypoc.di

import android.content.Context
import androidx.room.Room
import com.example.hiltdependencypoc.BaseApplication
import com.example.hiltdependencypoc.room.AppDatabase
import com.example.hiltdependencypoc.room.BlogDao
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by deepak on {19/4/21}
 */

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext application: Context): AppDatabase {
        return Room.databaseBuilder(application,AppDatabase::class.java,AppDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideDao(appDatabase: AppDatabase): BlogDao {
        return appDatabase.blogDao()
    }



}