package com.example.hiltdependencypoc.network

import com.example.hiltdependencypoc.model.RepositoriesModel
import javax.inject.Inject

/**
 * Created by deepak on {21/4/21}
 */

class ApiServiceImpl @Inject constructor(private val apiServices: ApiServices) {

    suspend fun getRepositoriesList(since: String): RepositoriesModel {
        return apiServices.getPublicRepositories(since)
    }

}