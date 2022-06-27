package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapterClass(val todolist:List<TodosItem>):RecyclerView.Adapter<MainAdapterClass.InnerClass>() {
    class InnerClass(itemview:View):RecyclerView.ViewHolder(itemview) {
        val textView1:TextView
        val textView2:TextView
        val textView3:TextView
        val textView4:TextView
        init {
        textView1=itemview.findViewById<TextView>(R.id.textView1)
            textView2=itemview.findViewById<TextView>(R.id.textView2)
            textView3=itemview.findViewById<TextView>(R.id.textView3)
            textView4=itemview.findViewById<TextView>(R.id.textView4)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerClass {
        return InnerClass(LayoutInflater.from(parent.context).inflate(R.layout.finallayout,parent,false))
    }

    override fun onBindViewHolder(holder: InnerClass, position: Int) {
   holder.textView1.text=todolist[position].userId.toString()
   holder.textView2.text=todolist[position].id.toString()
   holder.textView3.text=todolist[position].title
        holder.textView4.text=todolist[position].completed.toString()
    }

    override fun getItemCount(): Int {
return todolist.size
    }
}