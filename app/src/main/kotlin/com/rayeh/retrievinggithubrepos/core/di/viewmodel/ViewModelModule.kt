package com.rayeh.retrievinggithubrepos.core.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.rayeh.retrievinggithubrepos.com.rayeh.retrievinggithubrepos.features.repos.GithubViewModel
import com.rayeh.retrievinggithubreposcore.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(GithubViewModel::class)
    abstract fun bindsGithubViewModel(githubDetailsViewModel: GithubViewModel ): ViewModel

   }