package com.rayeh.retrievinggithubrepos.com.rayeh.retrievinggithubrepos.features.repos

import com.google.gson.annotations.SerializedName

class OwnerResponse {



    @SerializedName("login")
    var login: String? = null
    @SerializedName("id")
    var idd: Long? = 0
    @SerializedName("node_id")
    var node_id: String? = null
    @SerializedName("avatar_url")
    var avatar_url : String? = null
    @SerializedName("gravatar_id")
    var gravatar_id: String? = null
    @SerializedName("url")
    var urll: String? = null
    @SerializedName("html_url")
    var html_url: String? = null
    @SerializedName("followers_url")
    var followers_url: String? = null
    @SerializedName("following_url")
    var following_url: String? = null
    @SerializedName("gists_url")
    var gists_url : String? = null
    @SerializedName("starred_url")
    var starred_url: String? = null
    @SerializedName("subscriptions_url")
    var subscriptions_url: String? = null
    @SerializedName("organizations_url")
    var organizations_url: String? = null
    @SerializedName("repos_url")
    var repos_url: String? = null
    @SerializedName("events_url")
    var events_url : String? = null
    @SerializedName("received_events_url")
    var received_events_url: String? = null
    @SerializedName("type")
    var type: String? = null
    @SerializedName("site_admin")
    var site_admin: Boolean? = true

}