package com.uzb7.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val name:String,
    val age:Int,
    val password:String
)