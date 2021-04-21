package com.example.hiltdependencypoc.di

import com.example.hiltdependencypoc.network.ApiServiceImpl
import com.example.hiltdependencypoc.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by deepak on {21/4/21}
 */

@Module
@InstallIn(SingletonComponent::class)
object MainRepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(apiServiceImpl: ApiServiceImpl):MainRepository{
        return MainRepository(apiServiceImpl)
    }

}