package com.rayeh.retrievinggithubrepos.features.repos

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import com.rayeh.retrievinggithubrepos.R
import com.rayeh.retrievinggithubrepos.core.platform.BaseActivity
import com.rayeh.retrievinggithubrepos.features.repos.GithubResponse

class GithubDetailActivity: Activity()  {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.github_detail_activity)


        val title = intent.extras.getString(EXTRA_TITLE)
        val url = intent.extras.getString(EXTRA_URL)


        setTitle(title)


        webView = findViewById(R.id.detail_web_view)


        webView.loadUrl(url)

    }
    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_URL = "url"

        fun newIntent(context: Context, github: GithubResponse): Intent {
            val detailIntent = Intent(context, GithubDetailActivity::class.java)

            detailIntent.putExtra(EXTRA_TITLE, github.ownerr?.login)
            detailIntent.putExtra(EXTRA_URL, github.html_url)

            return detailIntent
        }
    }

}