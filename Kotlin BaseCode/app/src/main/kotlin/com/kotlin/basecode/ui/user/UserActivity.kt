package com.kotlin.basecode.ui.user

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.kotlin.basecode.R
import com.kotlin.basecode.base.BaseActivity
import com.kotlin.basecode.databinding.ActivityUserBinding
import com.kotlin.basecode.model.User

/**
 * Activity displaying the list of users
 */
class UserActivity : BaseActivity<UserPresenter>(), UserView {
    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityUserBinding

    /**
     * The adapter for the list of posts
     */
    private val usersAdapter = UserAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user)
        binding.adapter = usersAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updateUsers(users: List<User>) {
        usersAdapter.updateUsers(users)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun instantiatePresenter(): UserPresenter {
        return UserPresenter(this)
    }
}