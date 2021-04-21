package com.example.hiltdependencypoc.repository

import com.example.hiltdependencypoc.model.RepositoriesModel
import com.example.hiltdependencypoc.network.ApiServiceImpl
import com.example.hiltdependencypoc.network.ResultData
import javax.inject.Inject

/**
 * Created by deepak on {21/4/21}
 */


class MainRepository @Inject constructor(private val apiServiceImpl: ApiServiceImpl) {

    suspend fun getRepositoriesList(since: String): ResultData<RepositoriesModel> {
        val repositoriesModel = apiServiceImpl.getRepositoriesList(since = since)
        return when(repositoriesModel.isNotEmpty()) {
            true -> {
                ResultData.Success(repositoriesModel)
            }
            else -> {
                ResultData.Failed()
            }
        }
    }

}