package com.rayeh.retrievinggithubrepos.com.rayeh.retrievinggithubrepos.features.repos

import android.os.Bundle
import android.support.annotation.StringRes
import android.view.View
import android.widget.ListView
import com.rayeh.retrievinggithubrepos.core.platform.BaseFragment
import com.rayeh.retrievinggithubrepos.R
import com.rayeh.retrievinggithubrepos.features.repos.GithubFailure.ListNotAvailable
import com.rayeh.retrievinggithubrepos.core.exception.Failure
import com.rayeh.retrievinggithubrepos.core.exception.Failure.NetworkConnection
import com.rayeh.retrievinggithubrepos.core.exception.Failure.ServerError
import com.rayeh.retrievinggithubrepos.core.extension.failure
import com.rayeh.retrievinggithubrepos.core.extension.observe
import com.rayeh.retrievinggithubrepos.core.extension.invisible
import com.rayeh.retrievinggithubrepos.core.extension.viewModel
import com.rayeh.retrievinggithubrepos.core.extension.visible
import com.rayeh.retrievinggithubrepos.core.Navigation.Navigator
import com.rayeh.retrievinggithubrepos.features.repos.GithubAdapter
import com.rayeh.retrievinggithubrepos.features.repos.GithubDetailActivity
import com.rayeh.retrievinggithubrepos.features.repos.GithubResponse
import kotlinx.android.synthetic.main.fragment_github.emptyView
import kotlinx.android.synthetic.main.fragment_github.githubList
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject


class GithubFragment : BaseFragment() {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var githubAdapter: GithubAdapter



    private lateinit var listView: ListView
    private lateinit var githubViewModel: GithubViewModel

    override fun layoutId() = R.layout.fragment_github

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)




        githubViewModel = viewModel(viewModelFactory) {
             observe(github, ::renderGithubList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.githubList)

        loadGithubList()
    }




    private fun loadGithubList() {
        emptyView.invisible()
        githubList.visible()
        showProgress()
        githubViewModel.loadGithub()
    }

    private fun renderGithubList(github: List<GithubResponse>?) {


        var list = github.orEmpty()
        var array = arrayOfNulls<GithubResponse?>(list?.size)




        if (array?.size != 0) {
            for (i in 0 until list.size) {
                val value = list[i]
                array?.set(i, value)
            }


            val adapter = this.context?.let { GithubAdapter(it) }
            if (adapter != null) {
                adapter.dataSource = array
            }
            listView.adapter = adapter


            listView.setOnItemClickListener { _, _, position, _ ->

                val selectedGithub = array[position] as GithubResponse


                val detailIntent = this.context?.let {
                    selectedGithub?.let { it1 ->
                        GithubDetailActivity.newIntent(
                            it,
                            it1
                        )
                    }
                }


                startActivity(detailIntent)

                hideProgress()
                //toolbar.title = array?.get(0)?.ownerr?.login
            }


        }}

    fun handleFailure(failure: Failure?) {
        when (failure) {
            is NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is ServerError -> renderFailure(R.string.failure_server_error)
            is ListNotAvailable -> renderFailure(R.string.failure_github_list_unavailable)
        }
    }

    private fun renderFailure(@StringRes message: Int) {
        githubList.invisible()
        emptyView.visible()
        hideProgress()
        notifyWithAction(message, R.string.action_refresh, ::loadGithubList)
    }
}
