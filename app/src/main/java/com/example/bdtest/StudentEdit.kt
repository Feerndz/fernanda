package com.example.bdtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.bdtest.Data.StudentEntity
import com.example.bdtest.Data.StudentsDb
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_student_delete.*
import kotlinx.android.synthetic.main.activity_student_delete.edtID
import kotlinx.android.synthetic.main.activity_student_edit.*

class StudentEdit : AppCompatActivity() {

    val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_edit)

        btnEdit.setOnClickListener(){
            val student = StudentEntity()

            val idStudent:String = edtID.text.toString()

            student.id = idStudent.toInt()
            student.name = edtNameEdit.text.toString()
            student.lastName = edtLastnameEdit.text.toString()
            student.gender = spnGenderEdit.selectedItemPosition
            student.birthday = edtBirthdayEdit.text.toString()

            var values = StudentEntity(student.id,student.name,student.lastName,student.gender,student.birthday)
            var id:Int = studentsDb.studentsEdit(values)

            clean()

            Toast.makeText(this@StudentEdit,"Elemento editado", Toast.LENGTH_SHORT).show()
            Log.d("UDELP","El Id del elemento ectualizado es $id")

            studentsDb.studentsGA()
        }

    }

    fun clean(){
        edtID!!.text.clear()
        edtNameEdit!!.text.clear()
        edtLastnameEdit!!.text.clear()
        spnGenderEdit.setSelection(0)
        edtBirthdayEdit!!.text.clear()
    }

}
