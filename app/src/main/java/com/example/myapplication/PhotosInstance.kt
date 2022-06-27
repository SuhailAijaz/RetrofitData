package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PhotosInstance {
    private val BaseUrl="https://jsonplaceholder.typicode.com/"
    private val photosInterface:PhotosInterface?=null
    fun getPhotosService():PhotosInterface{
        return Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build().
                create(PhotosInterface::class.java)
        return photosInterface!!
    }
}