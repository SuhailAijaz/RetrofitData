package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface PhotosInterface {
    @GET("photos")
    fun getphotosdata(): Call<List<PhotosDataItem>>
}