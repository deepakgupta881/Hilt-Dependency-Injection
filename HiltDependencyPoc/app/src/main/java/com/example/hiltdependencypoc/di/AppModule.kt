package com.example.hiltdependencypoc.di

import android.content.Context
import com.example.hiltdependencypoc.BaseApplication
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
object AppModule {

    @Provides
    @Singleton
    fun provideBaseApplicationContext(@ApplicationContext application: Context): BaseApplication {
        return application as BaseApplication
    }


}