package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhotosAdapter(val photoslist:List<PhotosDataItem>):RecyclerView.Adapter<PhotosAdapter.InnerClass>() {
    class InnerClass(itemview: View):RecyclerView.ViewHolder(itemview) {
        val firsttext:TextView
        val textView5:TextView
        val textView6:TextView
        val textView7:TextView
        val textView8:TextView

        init {
            firsttext=itemview.findViewById(R.id.firsttext)
            textView5=itemview.findViewById(R.id.textView5)
            textView6=itemview.findViewById(R.id.textView6)
            textView7=itemview.findViewById(R.id.textView7)
            textView8=itemview.findViewById(R.id.textView8)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerClass {
return InnerClass(LayoutInflater.from(parent.context).inflate(R.layout.photoslayout,parent,false))
    }

    override fun onBindViewHolder(holder: InnerClass, position: Int) {
holder.firsttext.text=photoslist[position].albumId.toString()
holder.textView5.text=photoslist[position].id.toString()
holder.textView6.text=photoslist[position].title
holder.textView7.text=photoslist[position].url
holder.textView8.text=photoslist[position].thumbnailUrl
    }

    override fun getItemCount(): Int {
return photoslist.size
    }
}