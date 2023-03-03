package com.example.assessment

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.TextView
import java.util.jar.Attributes

class myDbHelper(context : Context): SQLiteOpenHelper(context,"USER1",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("Create table workshop(id INTEGER Primary key autoincrement,Name Varchar(50))")
        db?.execSQL("Insert into workshop(id,Name) values(1,'SDK Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(2,'Fragments Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(3,'Layouts Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(4,'REST APIs Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(5,'Features Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(6,'Authentication Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(7,'Recyclerview Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(8,'SQL Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(9,'Firebase Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(10,'Navigations Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(11,'UI Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(12,'Jetpack compose Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(13,'Kotlin Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(14,'Java Workshop')")
        db?.execSQL("Insert into workshop(id,Name) values(15,'Icons Workshop')")

    }



    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }


    @SuppressLint("Range")
    fun getAllworkshops():ArrayList<studentModel>{
        val stdList:ArrayList<studentModel> = ArrayList()

        val selectQuery="SELECT * FROM workshop"
        val db=this.readableDatabase
        val cursor:Cursor?
        /*try {*/
            cursor=db.rawQuery(selectQuery,null)

        /*}catch (e:Exception){
            db.execSQL(selectQuery)
            e.printStackTrace()
            return ArrayList()
        }*/
        var id:Int
        var name:String



            if(cursor.moveToFirst()){
                do {
                    id=cursor.getInt(cursor.getColumnIndex("id"))
                    name=cursor.getString(cursor.getColumnIndex("Name"))
                    val std=studentModel(id=id,name=name)
                    stdList.add(std)
                }while(cursor.moveToNext())
            }


        return stdList

    }


}