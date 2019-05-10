package com.rayeh.retrievinggithubrepos.core.di

import com.rayeh.retrievinggithubrepos.AndroidApplication
import com.rayeh.retrievinggithubrepos.com.rayeh.retrievinggithubrepos.features.repos.GithubFragment
import com.rayeh.retrievinggithubrepos.core.di.viewmodel.ViewModelModule
import com.rayeh.retrievinggithubrepos.core.Navigation.RouteActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(routeActivity: RouteActivity)


    fun inject(githubFragment: GithubFragment)






}