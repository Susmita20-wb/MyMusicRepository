package com.susmita.musicclub.network

import com.susmita.musicclub.network.model.Music
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val Base_Url="https://itunes.apple.com/"
interface MusicNetwork {

    @GET("search?")
    fun getMusic( @Query("term")searchString: String) : Call<List<Music>>
}