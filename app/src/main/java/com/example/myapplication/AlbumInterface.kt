package com.example.myapplication

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface AlbumInterface {
    @GET("albums")
    suspend fun getAlbumData():Response<AlbumsData>
//    fun getAlbumData(): Call<List<AlbumsDataItem>>
}