package com.susmita.musicclub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.susmita.musicclub.R
import com.susmita.musicclub.network.model.Music
import kotlinx.android.synthetic.main.rv_music_child.*
import kotlinx.android.synthetic.main.rv_music_child.view.*

class MusicAdapter (private val context: Context) :
        RecyclerView.Adapter<MusicAdapter.ViewHolder>(){
    private var list:List<Music> = ArrayList()

    fun setMusicList(list:List<Music>){
        this.list=list
        notifyDataSetChanged()
    }

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val name=view.tv_music_name
        val trackname=view.tv_trackname
        val rootview=view.child_root

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_music_child,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MusicAdapter.ViewHolder, position: Int) {
       holder.name.text=list[position].kind
       holder.trackname.text=list[position].trackName
    }


}