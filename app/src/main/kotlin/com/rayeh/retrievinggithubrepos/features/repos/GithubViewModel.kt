package com.rayeh.retrievinggithubrepos.com.rayeh.retrievinggithubrepos.features.repos

import android.arch.lifecycle.MutableLiveData
import com.rayeh.retrievinggithubrepos.core.platform.BaseViewModel
import com.rayeh.retrievinggithubrepos.core.platform.NetworkHandler
import com.rayeh.retrievinggithubrepos.features.repos.GithubFailure
import retrofit2.Retrofit
import com.rayeh.retrievinggithubrepos.features.repos.GithubResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class GithubViewModel

@Inject constructor(private val networkHandler: NetworkHandler): BaseViewModel() {


    var github:MutableLiveData<List<GithubResponse>> = MutableLiveData()

    fun loadGithub() {

        if (networkHandler.isConnected == true) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(GithubService::class.java)
            val call = service.github()


            call.enqueue(object : retrofit2.Callback<List<GithubResponse>> {
                override fun onResponse(call: Call<List<GithubResponse>>, response: Response<List<GithubResponse>>) {
                    if (response.code() == 200) {
                        github.value = response.body()

                    } else {
                        GithubFailure.ListNotAvailable()
                    }
                }

                override fun onFailure(call: Call<List<GithubResponse>>, t: Throwable) {
                    GithubFailure.ListNotAvailable()
                }
            })}else{
            GithubFailure.ListNotAvailable()
        }

        }



}