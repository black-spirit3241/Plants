package com.mvp.plants.persistence.daos

import androidx.room.*
import com.mvp.plants.data.vos.LoginUserVO

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user:LoginUserVO)

    @Query("select * from users")
    fun getUser():LoginUserVO

    @Query("delete from users")
    fun logOutUser()
}