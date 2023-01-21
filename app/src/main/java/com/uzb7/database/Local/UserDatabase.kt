package com.uzb7.database.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uzb7.database.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase:RoomDatabase(){

    abstract fun getUserDao():UserDao

    companion object{
        private var DB_INSTANCE:UserDatabase?=null

        fun getAppInstance(context: Context):UserDatabase{
            if (DB_INSTANCE==null){
                DB_INSTANCE= Room.databaseBuilder(context.applicationContext,UserDatabase::class.java,"users").allowMainThreadQueries().build()
            }
            return DB_INSTANCE!!
        }
    }

}