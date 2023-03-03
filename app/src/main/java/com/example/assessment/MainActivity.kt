package com.example.assessment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), userAdapter.applied {
    private lateinit var sqliteHelper: myDbHelper
    private lateinit var recyclerView: RecyclerView

    private var adapter:userAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.workshops_view)
        initView()
        sqliteHelper= myDbHelper(this)
        getStudents()



    }

    private fun getStudents() {
        val stdList=sqliteHelper.getAllworkshops()
        Log.e("pppp","${stdList.size}")
        adapter?.addItems(stdList)
    }

    private fun initView() {
        recyclerView.layoutManager=LinearLayoutManager(this)
        adapter= userAdapter(this)
        recyclerView.adapter=adapter
    }

    override fun clickedApplied() {
        Toast.makeText(this,"Applied",Toast.LENGTH_SHORT).show()

        val intent=Intent(this,LoginActivity::class.java)
        startActivity(intent)

    }


}