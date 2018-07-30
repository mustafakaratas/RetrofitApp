package com.example.mustafa_karatas.a18_07_11_retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
//GET https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UC7Lu-ONZhIM_lvKnZn0F19Q&maxResults=50&key={YOUR_API_KEY}
    @GET("playlists?part=snippet")
    fun tumListeleriGetir(@Query("channelId") channelId : String, @Query("maxResults") maxResults:Int,
                          @Query("key") key : String) : Call<PlaylistData>
}