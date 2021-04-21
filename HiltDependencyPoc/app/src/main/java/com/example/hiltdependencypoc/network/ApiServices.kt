package com.example.hiltdependencypoc.network;

import androidx.lifecycle.LiveData
import com.example.hiltdependencypoc.model.RepositoriesModel
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET
import retrofit2.http.POST;
import retrofit2.http.Query

interface ApiServices {

    @POST("device/auth")
    fun getDeviceAuth(@Body request:RequestBody): LiveData<String>

    @GET(NetworkingConstants.URL_REPOSITORIES)
    suspend fun getPublicRepositories(
        @Query("since") since: String
    ): RepositoriesModel

}