package com.example.roomdbdemo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MyEntity::class],version = 2)
abstract  class MyDB : RoomDatabase(){

    abstract  fun myDao() : MyDAOInterface
}