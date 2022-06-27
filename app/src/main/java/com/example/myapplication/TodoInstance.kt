package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object TodoInstance {
    private val BaseUrl="https://jsonplaceholder.typicode.com/"
    private val todoInterface:TodoInterface?=null
    fun getServiceData():TodoInterface{
        return Retrofit.Builder().baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build().create(TodoInterface::class.java)

    }

}