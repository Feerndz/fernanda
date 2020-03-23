package com.example.bdtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.bdtest.Data.StudentEntity
import com.example.bdtest.Data.StudentsDb
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_student_delete.*

class StudentDelete : AppCompatActivity() {

    val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_delete)

        btnDelete.setOnClickListener(){

            val student = StudentEntity()

            val idStudent:String = edtID.text.toString()
            student.id = idStudent.toInt()
            val id = studentsDb.studentsDelete(student.id)
            clean()
            Toast.makeText(this@StudentDelete,"Elemento eliminado", Toast.LENGTH_SHORT).show()
            Log.d("UDELP","El Id del elemento eliminado es $id")
        }

    }

    fun clean() {
        edtID!!.text.clear()
    }

}
