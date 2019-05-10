package com.rayeh.retrievinggithubrepos.features.repos

import com.google.gson.annotations.SerializedName
import com.rayeh.retrievinggithubrepos.com.rayeh.retrievinggithubrepos.features.repos.OwnerResponse

class GithubResponse {





    @SerializedName("id")
    var idd: Long? = 0
    @SerializedName("node_id")
    var node_id: String? = null
    @SerializedName("name")
    var namee : String? = null
    @SerializedName("full_name")
    var full_name: String? = null
    @SerializedName("private")
    var privatee: String? = null
    @SerializedName("owner")
    var ownerr: OwnerResponse? = null
    @SerializedName("html_url")
    var html_url: String? = null

}
