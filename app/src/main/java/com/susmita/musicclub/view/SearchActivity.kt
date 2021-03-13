package com.susmita.musicclub.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.widget.ImageViewCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.*
import com.susmita.musicclub.R
import com.susmita.musicclub.adapter.MusicAdapter
import com.susmita.musicclub.viewModel.SearchActivityViewModel
import kotlinx.android.synthetic.main.activity_search.*
import java.lang.reflect.Array.get

class SearchActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchActivityViewModel
    private lateinit var adapter: MusicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        viewModel=ViewModelProvider(this).get(SearchActivityViewModel::class.java)


        iv_search.setOnClickListener{
            if (et_Search.text!!.isNotEmpty())
            viewModel.searchMusic(et_Search.text.toString())
        }

        viewModel.progress.observe(this, Observer {
            if(it){
                progressbar.visibility= VISIBLE
            }
            else{
                progressbar.visibility= GONE
            }
        })

        viewModel.musicList.observe(this,Observer{
            adapter.setMusicList(it)
        })

        adapter= MusicAdapter(this)
        rv_search.adapter=adapter

    }

}




