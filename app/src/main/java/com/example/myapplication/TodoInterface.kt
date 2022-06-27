package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
interface TodoInterface {
    @GET("todos")
    fun getData(): Call<List<TodosItem>>
}