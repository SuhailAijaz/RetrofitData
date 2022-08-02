package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object AlbumInstance {
    private var BaseUrl="https://jsonplaceholder.typicode.com/"
    private val albumInterface:AlbumInterface?=null
    fun getAlbumService():AlbumInterface{
        return Retrofit.Builder().baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(AlbumInterface::class.java)
        return albumInterface!!
    }

}