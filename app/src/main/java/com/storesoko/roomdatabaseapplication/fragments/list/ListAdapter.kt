package com.storesoko.roomdatabaseapplication.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.storesoko.roomdatabaseapplication.R
import com.storesoko.roomdatabaseapplication.data.User
import kotlinx.android.synthetic.main.customer_row.view.*

class ListAdapter :RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private var userList = emptyList<User>()

  class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var id1  = itemView.id
        val firstName = itemView.firstName
        val lastName = itemView.lastName
        val age = itemView.age

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.customer_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.id1= currentItem.id
        holder.firstName.text = currentItem.firstName
        holder.lastName.text = currentItem.lastName
        holder.age.text =currentItem.age.toString()


    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}