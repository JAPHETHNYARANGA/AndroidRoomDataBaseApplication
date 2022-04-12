package com.storesoko.roomdatabaseapplication.Repository

import androidx.lifecycle.LiveData
import com.storesoko.roomdatabaseapplication.data.User
import com.storesoko.roomdatabaseapplication.data.UserDao

class UserRepository(private val userDao: UserDao) {

    val readAllData : LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}