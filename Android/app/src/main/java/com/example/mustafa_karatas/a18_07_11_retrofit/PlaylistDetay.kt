package com.example.mustafa_karatas.a18_07_11_retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_playlist_detay.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistDetay : AppCompatActivity() {

    val KEY = "AIzaSyA1ShrbFIHJcwKDZhCvfep41e6d3A13rZ0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_detay)

        var id = intent.extras.getString("tiklananElamaninIdsi")
        var playlistInterface = ApiClient.client?.create(PlaylistItemInterface::class.java)
        var request = playlistInterface?.playlistItemlarıGetir(50,id,KEY)
        request?.enqueue(object : Callback<ListItemData>{

            override fun onFailure(call: Call<ListItemData>?, t: Throwable?) {            }

            override fun onResponse(call: Call<ListItemData>?, response: Response<ListItemData>?) {

                var gelenItems = response?.body()?.items
                var adapter = AdapterListItem(gelenItems)
                rvPlaylistItem.adapter = adapter
                rvPlaylistItem.layoutManager = LinearLayoutManager(this@PlaylistDetay,LinearLayoutManager.VERTICAL,false)
            }

        })
    }
}
