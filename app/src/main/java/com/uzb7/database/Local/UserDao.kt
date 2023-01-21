package com.uzb7.database.Local

import androidx.room.*
import com.uzb7.database.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: User)

    @Query("SELECT * FROM users")
    fun getUsers():List<User>

    @Query("DELETE FROM users WHERE id=:id")
    fun deleteUser(id:Int)

    @Query("DELETE FROM users")
    fun clearUsers()

    @Delete
    fun deleteUser2(user: User)
}
