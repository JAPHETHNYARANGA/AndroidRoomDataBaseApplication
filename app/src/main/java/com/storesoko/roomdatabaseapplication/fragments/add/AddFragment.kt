package com.storesoko.roomdatabaseapplication.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.storesoko.roomdatabaseapplication.R
import com.storesoko.roomdatabaseapplication.ViewModel.UserViewModel
import com.storesoko.roomdatabaseapplication.data.User
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class addFragment : Fragment() {

private lateinit var mUserViewModel : UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add.setOnClickListener{
            insertDataToDatabase()
        }

        return  view
    }

    private fun insertDataToDatabase() {
        val firstName = firstName.text.toString().trim()
        val lastName = lastName.text.toString().trim()
        val age = age.text.toString().trim()
        if(validate(firstName, lastName, age)){
            val user = User(0,firstName, lastName,Integer.parseInt(age.toString()))
            //adding data to our db
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"User Added successfully", Toast.LENGTH_SHORT).show()

            //navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"something went wrong", Toast.LENGTH_SHORT).show()
        }
    }


    private fun validate(firstName:String, lastName:String, age: String):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName)&& age.isEmpty())
    }

}