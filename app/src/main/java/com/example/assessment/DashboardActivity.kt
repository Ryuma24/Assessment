package com.example.assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {
    private lateinit var sqliteHelper: myDbHelper
    private lateinit var recyclerView: RecyclerView

    private var adapter:loginAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView=findViewById(R.id.dashboardView)
        initView()
        sqliteHelper= myDbHelper(this)
        getStudents()

    }

    private fun getStudents() {
        val stdList=sqliteHelper.getAllworkshops()
        adapter?.addItems(stdList)
    }

    private fun initView() {
        recyclerView.layoutManager= LinearLayoutManager(this)
        adapter= loginAdapter()
        recyclerView.adapter=adapter
    }


}