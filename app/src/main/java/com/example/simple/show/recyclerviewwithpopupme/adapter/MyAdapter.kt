package com.example.simple.show.recyclerviewwithpopupme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.simple.show.recyclerviewwithpopupme.R
import com.example.simple.show.recyclerviewwithpopupme.model.Model
import com.google.android.material.snackbar.Snackbar

class MyAdapter(val context: Context, var Data: ArrayList<Model>) :
    RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder>() {

    lateinit var temp : Model

    inner class MyAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val vieww = view
        val mContext = view.context
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val menuPopu: ImageView = view.findViewById(R.id.menuMore)
        val name: TextView = view.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterViewHolder =
        MyAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        )

    override fun onBindViewHolder(holder: MyAdapterViewHolder, position: Int) {

        holder.name.text = Data[position].name
        holder.imageView.setImageResource(Data[position].image)
        holder.menuPopu.setOnClickListener {

            val popuMenu = PopupMenu(context, it)
            popuMenu.inflate(R.menu.pop_menu)

            popuMenu.setOnMenuItemClickListener {
                when(it!!.itemId){
                    R.id.popupMenu_Edit -> {
                        Toast.makeText(context,"edit",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.popupMenu_Delete -> {
                        Toast.makeText(context,"delete",Toast.LENGTH_SHORT).show()
                        temp = Model(Data[position].name,Data[position].image)
                        deleteItem(position,holder.vieww,holder.mContext)
                        true
                    }
                    else -> false
                }
            }

            popuMenu.show()

        }

    }

    private fun deleteItem(position: Int,view: View,context: Context){
        Data.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,Data.size)
        Snackbar.make(view,"undo Deletion of  : ${temp.name}",Snackbar.LENGTH_LONG )
            .setAction("UNDO"){

                Data.add(position,temp)
                notifyItemChanged(position)
                notifyItemRangeChanged(position,Data.size)

            }.setActionTextColor(context.resources.getColor(android.R.color.holo_blue_dark))
            .show()
    }

    override fun getItemCount(): Int = Data.size

}