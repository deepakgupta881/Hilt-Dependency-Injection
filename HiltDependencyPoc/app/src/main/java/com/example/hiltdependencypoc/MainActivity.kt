package com.example.hiltdependencypoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var application: BaseApplication
    @Inject
    @Named("String 2")
    lateinit var appString: String

    @Inject
    @Named("String 1")
    lateinit var appString1: String


    @Inject
    lateinit var gson: Gson
    @Inject
    lateinit var retrofit: Retrofit.Builder

    @Inject
    lateinit var apiServices: ApiServices


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("AppContext",application.toString() + appString + appString1)
        Log.d("AppContext",gson.toString())
        Log.d("AppContext",retrofit.toString())
        Log.d("AppContext",apiServices.toString())
    }

}