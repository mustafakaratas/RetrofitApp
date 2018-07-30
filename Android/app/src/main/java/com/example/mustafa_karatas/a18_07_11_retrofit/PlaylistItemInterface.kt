package com.example.mustafa_karatas.a18_07_11_retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaylistItemInterface {
    // playlistItems?part=snippet&maxResults=50&playlistId=PLobVbNmsCgSWFFo5DtlD8vxCcbgiAvTiB&key={YOUR_API_KEY}
    @GET("playlistItems?part=snippet")
    fun playlistItemlarıGetir(@Query("maxResults") maxResult : Int,
                              @Query("playlistId") id : String,
                              @Query("key") key : String)
            : Call<ListItemData>
}