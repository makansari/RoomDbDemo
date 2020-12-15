package com.example.roomdbdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = Room.databaseBuilder(this,MyDB::class.java,"mydatabase")
            .fallbackToDestructiveMigration().build()
            var h = Handler()
        Thread{

                var users = MyEntity()
                users.myid = 1
                users.myname = "ansari"
                users.age = 35

                db.myDao().saveData(users)

                // Reading Data

                db.myDao().readData().forEach {
                    h.post {
                        var result = "id : ${it.myid} with name ${it.myname} of age ${it.age} "
                        Toast.makeText(this,"result is " + result, Toast.LENGTH_LONG).show()
                    }

                }



        }.start()


    }


}