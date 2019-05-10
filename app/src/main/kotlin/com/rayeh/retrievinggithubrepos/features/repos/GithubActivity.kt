package com.rayeh.retrievinggithubrepos.features.repos


import android.content.Context
import android.content.Intent
import com.rayeh.retrievinggithubrepos.com.rayeh.retrievinggithubrepos.features.repos.GithubFragment
import com.rayeh.retrievinggithubrepos.core.platform.BaseActivity

class GithubActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, GithubActivity::class.java)
    }

    override fun fragment() = GithubFragment()
}