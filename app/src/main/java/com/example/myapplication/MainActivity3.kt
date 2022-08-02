package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {
   private  val madapter by lazy {
       AlbumAdapter()
   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val rxthird=findViewById<RecyclerView>(R.id.rxthird)
        rxthird.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity3)
            adapter=madapter
        }

        lifecycleScope.launch(Dispatchers.Main) {
            val final=withContext(Dispatchers.IO){
                AlbumInstance.getAlbumService().getAlbumData()
                }
            if(final.isSuccessful){
                Log.d("TAG", "onCreate: ${Thread.currentThread().name}")
                madapter.datapass(final.body()?:AlbumsData())
            }
        }
//        val final=AlbumInstance.getAlbumService().getAlbumData()
//        final.enqueue(object : Callback<List<AlbumsDataItem>?> {
//            override fun onResponse(
//                call: Call<List<AlbumsDataItem>?>, response: Response<List<AlbumsDataItem>?>, ) {
//                val finalresult=response.body()!!
//                madaper=AlbumAdapter(finalresult)
//                rxthird.adapter=madaper
//
//            }
//
//            override fun onFailure(call: Call<List<AlbumsDataItem>?>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
    }
}