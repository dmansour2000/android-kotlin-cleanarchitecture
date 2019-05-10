package com.rayeh.retrievinggithubrepos.com.rayeh.retrievinggithubrepos.features.repos

import com.rayeh.retrievinggithubrepos.features.repos.GithubResponse
import retrofit2.Call
import retrofit2.http.GET


internal interface GithubService
{
    @GET("users/johnsundell/repos")
    fun github() : Call<List<GithubResponse>>
}