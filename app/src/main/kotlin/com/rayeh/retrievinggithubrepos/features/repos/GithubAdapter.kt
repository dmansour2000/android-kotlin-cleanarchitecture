package com.rayeh.retrievinggithubrepos.features.repos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.rayeh.retrievinggithubrepos.R
import com.rayeh.retrievinggithubrepos.core.Navigation.Navigator
import javax.inject.Inject


class GithubAdapter
@Inject constructor(private val context: Context
                    ) : BaseAdapter() {

     var dataSource: Array<GithubResponse?> = emptyArray()

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater



    override fun getCount(): Int {
        if (dataSource != null) {
            return dataSource!!.size
        }else{
            return 0
        }
    }



    override fun getItem(position: Int): GithubResponse? {
        return dataSource?.get(position)
    }



    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.row_github, parent, false)


        val githubURL = rowView.findViewById(R.id.githubURL) as TextView


        val githubSummary = rowView.findViewById(R.id.githubSummary) as TextView


        val github = getItem(position) as GithubResponse


        githubURL.text = github.html_url
        githubSummary.text = github.namee



        return rowView
    }


}
