package com.example.bdtest.Data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class StudentsDb {

    private var connectionDb: ConnectionDb
    private lateinit var sqliteDatabase:SQLiteDatabase

    constructor(context:Context){
        connectionDb = ConnectionDb(context)
    }

    public fun studentsAdd(student:StudentEntity): Long{
        sqliteDatabase = connectionDb.openConnection(ConnectionDb.MODE_WRITE)

        val values = ContentValues()
        values.put(NAME,student.name)
        values.put(LASTNAME,student.lastName)
        values.put(GENDER,student.gender)
        values.put(BIRTHDAY,student.birthday)

        return sqliteDatabase.insert(ConnectionDb.TABLE_NAME_STUDENTS, null, values)
    }

    fun studentsEdit(student:StudentEntity): Int {
        sqliteDatabase = connectionDb.openConnection(ConnectionDb.MODE_WRITE)

        val values = ContentValues()
        values.put(NAME,student.name)
        values.put(LASTNAME,student.lastName)
        values.put(GENDER,student.gender)
        values.put(BIRTHDAY,student.birthday)
        var selection = "Id=?"
        var args = arrayOf(student.id.toString())

        return sqliteDatabase.update(ConnectionDb.TABLE_NAME_STUDENTS,values,selection,args)
    }

    fun studentsDelete(idStudent:Int): Int {
        sqliteDatabase = connectionDb.openConnection(ConnectionDb.MODE_WRITE)

        var selection = "Id=?"
        var args = arrayOf(idStudent.toString())

        return sqliteDatabase.delete(ConnectionDb.TABLE_NAME_STUDENTS,selection,args)
    }

    fun studentsGA(){
        sqliteDatabase = connectionDb.openConnection(ConnectionDb.MODE_READ)

        val fields = arrayOf(ID, NAME, LASTNAME, GENDER, BIRTHDAY)
        val cursor = sqliteDatabase.query(ConnectionDb.TABLE_NAME_STUDENTS, fields, null, null, null, null, null)

        if(cursor.moveToFirst()){
            do{
                Log.d("UDELP","${cursor.getInt(0)} ${cursor.getString(1)} ${cursor.getString(2)} ${cursor.getInt(0)} ${cursor.getString(3)}")
            }while(cursor.moveToNext())
        }
    }

    fun studentsGO(idStudent: Int){
        sqliteDatabase = connectionDb.openConnection(ConnectionDb.MODE_READ)

        val fields = arrayOf(ID, NAME, LASTNAME, GENDER, BIRTHDAY)
        var selection = "Id=?"
        var args = arrayOf(idStudent.toString())
        val cursor = sqliteDatabase.query(ConnectionDb.TABLE_NAME_STUDENTS, fields,selection,args,null,null,null)

        if(cursor.moveToFirst()){
            Log.d("UDELP","${cursor.getInt(0)} ${cursor.getString(1)} ${cursor.getString(2)} ${cursor.getInt(0)} ${cursor.getString(3)}")
        }
    }


    companion object{
        const val ID = "Id"
        const val NAME = "Name"
        const val LASTNAME = "Lastname"
        const val GENDER = "Gender"
        const val BIRTHDAY = "Birthday"
    }

}