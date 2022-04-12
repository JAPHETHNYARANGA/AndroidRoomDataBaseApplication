package com.storesoko.roomdatabaseapplication.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.storesoko.roomdatabaseapplication.Repository.UserRepository
import com.storesoko.roomdatabaseapplication.data.User
import com.storesoko.roomdatabaseapplication.data.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application : Application): AndroidViewModel(application) {

    private val readAllData:LiveData<List<User>>
    private  val repository:UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }


    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }
}