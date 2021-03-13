package com.susmita.musicclub.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.susmita.musicclub.network.Base_Url
import com.susmita.musicclub.network.MusicNetwork
import com.susmita.musicclub.network.model.Music
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivityRepository(application: Application) {

    val progress=MutableLiveData<Boolean>()
    val musicList=MutableLiveData<List<Music>>()

        fun changeState(){
            progress.value=!(progress.value!=null && progress.value!!)
        }

    fun searchMusic(searchString: String){
        progress.value=true

        val retrofit= Retrofit.Builder().baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create()).build()

        val service=retrofit.create(MusicNetwork::class.java)

        service.getMusic(searchString).enqueue(object : Callback<List<Music>>{
            override fun onFailure(call: Call<List<Music>>?, t: Throwable?) {
               progress.value=false

            }

            override fun onResponse(call: Call<List<Music>>, response: Response<List<Music>>?) {

                Log.d("SearchRepository","Response: ${Gson().toJson(response?.body())}")
                musicList.value=response?.body()
                progress.value=false
            }

        })
    }
}