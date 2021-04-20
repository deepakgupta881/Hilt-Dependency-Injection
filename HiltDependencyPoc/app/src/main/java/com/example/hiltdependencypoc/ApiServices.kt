package com.example.hiltdependencypoc;

import androidx.lifecycle.LiveData
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface ApiServices {
    @POST("device/auth")
    fun getDeviceAuth(@Body request:RequestBody): LiveData<String>

}