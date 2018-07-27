package com.kotlin.basecode.ui.user

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.basecode.R
import com.kotlin.basecode.databinding.ItemUserBinding
import com.kotlin.basecode.model.User

/**
 * Adapter for the list of the users
 * @property context Context in which the application is running
 */
class UserAdapter(private val context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    /**
     * The list of users of the adapter
     */
    private var users: List<User> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemUserBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_user, parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    /**
     * Updates the list of users of the adapter
     * @param users the new list of users of the adapter
     */
    fun updateUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for User item
     */
    class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a user into the view
         */
        fun bind(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }
    }
}