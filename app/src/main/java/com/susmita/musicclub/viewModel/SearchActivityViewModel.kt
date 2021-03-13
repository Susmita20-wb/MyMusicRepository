package com.susmita.musicclub.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.susmita.musicclub.network.model.Music
import com.susmita.musicclub.repository.SearchActivityRepository

class SearchActivityViewModel(application: Application): AndroidViewModel(application) {
    private val repository=SearchActivityRepository(application)
    val progress:LiveData<Boolean>
    val musicList: LiveData<List<Music>>

    init{
        this.progress=repository.progress
        this.musicList=repository.musicList
    }

    fun changeState(){
        repository.changeState()
    }

    fun searchMusic(searchString: String){
        repository.searchMusic(searchString)
    }
}