package com.example.hiltdependencypoc.di

import android.content.Context
import com.example.hiltdependencypoc.ApiServices
import com.example.hiltdependencypoc.BaseApplication
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
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
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.callTimeout(60, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClient.readTimeout(60, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(60, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(loggingInterceptor)
        okHttpClient.build()
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson,okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder().baseUrl("http://abc")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
    }


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit.Builder): ApiServices {
        return retrofit.build().create(ApiServices::class.java)
    }


    @Provides
    @Named("String 1")
    fun getGlobalString(): String {
        return "string 1"
    }


    @Provides
    @Named("String 2")
    fun getGlobalStringTwo(): String {
        return "string 2"
    }

}