package com.example.bdtest

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.bdtest.Data.StudentEntity
import com.example.bdtest.Data.StudentsDb

class MainActivity : AppCompatActivity() {

    val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.itmForm ->{
                val intent = Intent(this@MainActivity,StudentRegister::class.java)
                startActivity(intent)
            }

            R.id.itmGetAll->{
                val intent = Intent(this@MainActivity,StudentsGA::class.java)
                startActivity(intent)
            }

            R.id.itmGetOne ->{
                val intent = Intent(this@MainActivity,StudentsGO::class.java)
                startActivity(intent)
            }

            R.id.itmDelete->{
                val intent = Intent(this@MainActivity,StudentDelete::class.java)
                startActivity(intent)
            }

            R.id.itmEdit ->{
                val intent = Intent(this@MainActivity,StudentEdit::class.java)
                startActivity(intent)
            }

        }

        return true
    }

}