package com.example.mustafa_karatas.a18_07_11_retrofit

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tek_satir_playlist.view.*

class AdapterListItem(var gelenItems : List<ListItemData.İtems>?) : RecyclerView.Adapter<AdapterListItem.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        var tekSatir = LayoutInflater.from(parent.context).inflate(R.layout.tek_satir_playlist, parent, false)
        return viewHolder(tekSatir)
    }

    override fun getItemCount(): Int { return gelenItems!!.size }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        holder.gelenView.tvBaslik.text = gelenItems?.get(position)?.snippet?.title
        Picasso.get().load(gelenItems?.get(position)?.snippet?.thumbnails?.high?.url).into(holder.gelenView.civResim)
    }


    class viewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var gelenView = itemView as CardView
    }
}