package com.example.mustafa_karatas.a18_07_11_retrofit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tek_satir_playlist.view.*

class Adapter(var oynatmaListeleri : List<PlaylistData.items>?) : RecyclerView.Adapter<Adapter.PlaylistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {

        var tekSatir = LayoutInflater.from(parent.context).inflate(R.layout.tek_satir_playlist, parent, false)
        return PlaylistViewHolder(tekSatir)
    }

    override fun getItemCount(): Int {
        return oynatmaListeleri!!.size
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {

        holder.tekSatir.tvBaslik.text = oynatmaListeleri?.get(position)?.snippet?.title
        Picasso.get().load(oynatmaListeleri?.get(position)?.snippet?.thumbnails?.high?.url).into(holder.tekSatir.civResim)
        holder.tekSatir.setOnClickListener {
            var intent = Intent(it.context, PlaylistDetay::class.java)
            intent.putExtra("tiklananElamaninIdsi", oynatmaListeleri?.get(position)?.İd)
            it.context.startActivity(intent)

        }
    }


    class PlaylistViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){

        var tekSatir = itemView as CardView
    }

}