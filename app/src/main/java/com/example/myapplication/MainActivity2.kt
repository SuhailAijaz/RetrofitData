package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity(),View.OnClickListener{
    private lateinit var buttontwo:Button
    private lateinit var madapter:PhotosAdapter
    private lateinit var rxyltwo:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        buttontwo=findViewById(R.id.buttontwo)
        buttontwo.setOnClickListener(this)
        rxyltwo=findViewById(R.id.rxyltwo)
        rxyltwo.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity2)
        }
        val final=PhotosInstance.getPhotosService().getphotosdata()
        final.enqueue(object : Callback<List<PhotosDataItem>?> {
            override fun onResponse(
                call: Call<List<PhotosDataItem>?>,
                response: Response<List<PhotosDataItem>?>,
            ) {
                if(response.isSuccessful){
                    val photosdata=response.body()!!
                    madapter= PhotosAdapter(photosdata)
                    rxyltwo.adapter=madapter

                }
            }

            override fun onFailure(call: Call<List<PhotosDataItem>?>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")            }
        })
    }

    override fun onClick(p0: View?) {
val intent=Intent(this@MainActivity2,MainActivity3::class.java)
        startActivity(intent)
    }
}