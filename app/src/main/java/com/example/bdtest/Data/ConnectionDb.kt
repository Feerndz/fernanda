package com.example.bdtest.Data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.security.AccessControlContext

class ConnectionDb(context: Context) : SQLiteOpenHelper(context, BD_NAME, null, VERSION_BD){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_STUDENTS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE_STUDENTS)
    }

    fun openConnection(typeConnectionBD: Int):SQLiteDatabase{
        return when(typeConnectionBD){
            MODE_WRITE ->
                return writableDatabase
            MODE_READ ->
                return readableDatabase
            else ->
                return readableDatabase
        }
    }

    companion object {

        const val BD_NAME="STUDENTS_DATABASE"
        const val VERSION_BD=1
        const val TABLE_NAME_STUDENTS="CTL_STUDENTS"
        const val CREATE_TABLE_STUDENTS="CREATE TABLE CTL_STUDENTS(Id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(20),Lastname VARCHAR(15),Gender VARCHAR(50),Birthday DATE)"
        const val DROP_TABLE_STUDENTS="DROP TABLE IF EXISTS CTL_STUDENTS"
        const val MODE_WRITE=1
        const val MODE_READ=2

    }

}

