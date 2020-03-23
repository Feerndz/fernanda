package com.example.bdtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import com.example.bdtest.Data.StudentEntity
import com.example.bdtest.Data.StudentsDb

class StudentsGA : AppCompatActivity() {

    val studentsDb = StudentsDb(this)

    //private lateinit var lv ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_g)



    }
}
