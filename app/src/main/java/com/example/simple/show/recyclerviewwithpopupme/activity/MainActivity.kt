package com.example.simple.show.recyclerviewwithpopupme.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simple.show.recyclerviewwithpopupme.R
import com.example.simple.show.recyclerviewwithpopupme.adapter.MyAdapter
import com.example.simple.show.recyclerviewwithpopupme.model.Model

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    val listData = arrayListOf(
        Model("AlirezaBashi98", R.drawable.a),
        Model("tik", R.drawable.b),
        Model("AlirezaBashi98", R.drawable.a),
        Model("tik", R.drawable.b),
        Model("AlirezaBashi98", R.drawable.a),
        Model("tik", R.drawable.b),
        Model("AlirezaBashi98", R.drawable.a),
        Model("tik", R.drawable.b),
        Model("AlirezaBashi98", R.drawable.a),
        Model("tik", R.drawable.b),
        Model("AlirezaBashi98", R.drawable.a),
        Model("tik", R.drawable.b),
        Model("AlirezaBashi98", R.drawable.a),
        Model("tik", R.drawable.b),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Cast()

        myAdapter = MyAdapter(this, listData)

        recyclerView.adapter = myAdapter

        recyclerView.itemAnimator = DefaultItemAnimator()

    }

    private fun Cast() {

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

}