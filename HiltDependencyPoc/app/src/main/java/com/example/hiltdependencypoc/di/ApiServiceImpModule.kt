package com.example.hiltdependencypoc.di

import com.example.hiltdependencypoc.network.ApiServiceImpl
import com.example.hiltdependencypoc.network.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceImpModule {

    @Provides
    @Singleton
    fun providesApiServiceImp(apiServices: ApiServices): ApiServiceImpl {
        return ApiServiceImpl(apiServices)
    }
}