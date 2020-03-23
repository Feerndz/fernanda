package com.example.bdtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.bdtest.Data.StudentEntity
import com.example.bdtest.Data.StudentsDb
import kotlinx.android.synthetic.main.activity_register.*

class StudentRegister : AppCompatActivity() {

    val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val student = StudentEntity()

        btnSave.setOnClickListener(){
            student.name = edtName.text.toString()
            student.lastName = edtLastname.text.toString()
            student.gender = spnGender.selectedItemPosition
            student.birthday = edtBirthday.text.toString()

            val id = studentsDb.studentsAdd(student)

            clean()

            Toast.makeText(this@StudentRegister,"Elemento guardado", Toast.LENGTH_SHORT).show()
            Log.d("UDELP","El Id del elemento guardado es $id")

            studentsDb.studentsGA()
        }

    }

    fun clean(){
        edtName!!.text.clear()
        edtLastname!!.text.clear()
        spnGender.setSelection(0)
        edtBirthday!!.text.clear()
    }
}
