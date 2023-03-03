package com.example.assessment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class loginAdapter: RecyclerView.Adapter<userAdapter.studentViewHolder>() {
    private var stdList:ArrayList<studentModel> = ArrayList()
    fun addItems(items:ArrayList<studentModel>){
        this.stdList=items
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): userAdapter.studentViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.dash_items,parent,false)
        return userAdapter.studentViewHolder(view)
    }



    override fun getItemCount(): Int {
        return stdList.size
    }

    class studentViewHolder( var view: View):RecyclerView.ViewHolder(view){

        private var title=view.findViewById<TextView>(R.id.worskshop_title)
        private var id=view.findViewById<TextView>(R.id.ID)
        fun bindView(std: studentModel){
            id.text= std.id.toString()
            title.text= std.name
        }
    }
    override fun onBindViewHolder(
        holder: userAdapter.studentViewHolder,
        position: Int
    ) { val std=stdList[position]
        holder.bindView(std)
    }
}
