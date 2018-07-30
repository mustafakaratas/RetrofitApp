package com.example.mustafa_karatas.a18_07_11_retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val KEY = "AIzaSyA1ShrbFIHJcwKDZhCvfep41e6d3A13rZ0"
    val RESULTS = 25
    val CHANNEL_ID = "UC7Lu-ONZhIM_lvKnZn0F19Q"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var apiInterface = ApiClient.client?.create(ApiInterface::class.java)
        var apiCall = apiInterface?.tumListeleriGetir(CHANNEL_ID, RESULTS, KEY)
        apiCall?.enqueue(object : Callback<PlaylistData> {

            override fun onFailure(call: Call<PlaylistData>?, t: Throwable?) {

                Log.e("MUSTAFA", "HATA : "+ t?.printStackTrace())
            }

            override fun onResponse(call: Call<PlaylistData>?, response: Response<PlaylistData>?) {

                var gelenVeri = response?.body()
                var gelenPlaylist = gelenVeri?.mitems
                supportActionBar?.setSubtitle(gelenPlaylist?.size.toString())
                var playlistAdapter = Adapter(gelenPlaylist)
                rvPlaylist.adapter = playlistAdapter
                rvPlaylist.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            }

        })
    }
}
