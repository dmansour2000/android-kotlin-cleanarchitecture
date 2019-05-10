package com.rayeh.retrievinggithubrepos.core.Navigation

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import com.rayeh.retrievinggithubrepos.features.repos.GithubActivity
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Navigator
@Inject constructor() {


    fun showMain(context: Context) {

             showGithub(context)


    }

    private fun showGithub(context: Context) = context.startActivity(GithubActivity.callingIntent(context))







}


