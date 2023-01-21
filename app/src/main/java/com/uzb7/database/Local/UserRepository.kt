package com.uzb7.database.Local

import android.app.Application
import androidx.room.Delete
import androidx.room.Query
import com.uzb7.database.model.User


class UserRepository {
    lateinit var userDao: UserDao
    constructor(
        application: Application
    ){
        val db=UserDatabase.getAppInstance(application)
        userDao=db.getUserDao()
    }

    fun saveUser(user: User){
        userDao.saveUser(user)
    }

    fun getUsers():List<User>{
        return userDao.getUsers()
    }

    fun deleteUser(id:Int){
        userDao.deleteUser(id)
    }

    fun clearUsers(){
        userDao.clearUsers()
    }

    fun deleteUser2(user: User){
        userDao.deleteUser2(user)
    }

}