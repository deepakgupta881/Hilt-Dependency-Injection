package com.example.hiltdependencypoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.hiltdependencypoc.model.RepositoriesModel
import com.example.hiltdependencypoc.network.ApiServices
import com.example.hiltdependencypoc.network.ResultData
import com.example.hiltdependencypoc.viewmodel.MainViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var application: BaseApplication

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var retrofit: Retrofit.Builder

    @Inject
    lateinit var apiServices: ApiServices


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("AppContext",gson.toString())
        Log.d("AppContext",retrofit.toString())
        Log.d("AppContext",apiServices.toString())
        val repositoriesListLiveData = mainViewModel.getRepositoriesList("20")
        repositoriesListLiveData.observe(this, repositoryObserver)
    }
    private val repositoryObserver = Observer<ResultData<RepositoriesModel?>> { resultData ->
        when(resultData) {
            is ResultData.Loading -> {
                textView.text="Loading"
            }
            is ResultData.Success -> {
                val repositoriesModel = resultData.data
                textView.text=repositoriesModel.toString()

            }
            is ResultData.Failed -> {
                textView.text="Failed"

            }
            is ResultData.Exception -> {
                textView.text="exception"

            }
        }
    }

}