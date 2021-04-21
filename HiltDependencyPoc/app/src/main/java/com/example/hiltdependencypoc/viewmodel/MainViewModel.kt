package com.example.hiltdependencypoc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.hiltdependencypoc.model.RepositoriesModel
import com.example.hiltdependencypoc.network.ResultData
import com.example.hiltdependencypoc.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by deepak on {21/4/21}
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    fun getRepositoriesList(since: String): LiveData<ResultData<RepositoriesModel?>> {
        return flow {
            emit(ResultData.Loading())
            try {
                emit(mainRepository.getRepositoriesList(since = since))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ResultData.Exception())
            }
        }.asLiveData(Dispatchers.IO)
    }



}