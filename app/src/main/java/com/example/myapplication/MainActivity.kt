package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var button: Button
    private lateinit var mainAdapterClass: MainAdapterClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rxycl=findViewById<RecyclerView>(R.id.rxmain)
        button=findViewById(R.id.buttonone)
        button.setOnClickListener(this)
        rxycl.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            val home=TodoInstance.getServiceData().getData()
            home.enqueue(object : Callback<List<TodosItem>?> {
                override fun onResponse(
                    call: Call<List<TodosItem>?>, response: Response<List<TodosItem>?>, ) {
                    if(response.isSuccessful){
//                        val data=response.body()!!
                        mainAdapterClass=MainAdapterClass(response.body()!!)
                        rxycl.adapter=mainAdapterClass

//                        Toast.makeText(applicationContext," "+response.body(),Toast.LENGTH_SHORT).show()
//                        d("TAG", "onResponse: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<List<TodosItem>?>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")                }
            })

        }
    }

    override fun onClick(p0: View?) {
val intent= Intent(this@MainActivity,MainActivity2::class.java)
    startActivity(intent)}
}