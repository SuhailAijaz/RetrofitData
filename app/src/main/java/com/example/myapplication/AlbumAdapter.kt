package com.example.myapplication

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class AlbumAdapter():RecyclerView.Adapter<AlbumAdapter.Innerclass> (){

    class Innerclass(itemview:View):RecyclerView.ViewHolder(itemview) {
        val textView10:TextView
        val textView11:TextView
        val textView14:TextView
        init {
            textView10=itemview.findViewById(R.id.textView10)
            textView11=itemview.findViewById(R.id.textView11)
            textView14=itemview.findViewById(R.id.textView14)
        }

    }
private val userslist= mutableListOf<AlbumsDataItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Innerclass {
        return Innerclass(LayoutInflater.from(parent.context).inflate(R.layout.userslayout,parent,false))
    }

    override fun onBindViewHolder(holder: Innerclass, position: Int) {
        holder.textView10.text=userslist[position].userId.toString()
        holder.textView11.text=userslist[position].id.toString()
        holder.textView14.text=userslist[position].title
    }

    override fun getItemCount(): Int {
return userslist.size
    }

    fun datapass(list: List<AlbumsDataItem>) {
        userslist.clear()
        userslist.addAll(list)
        notifyDataSetChanged()

    }
}