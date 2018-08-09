package com.kotlin.basecode.ui.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import com.kotlin.basecode.R
import com.kotlin.basecode.base.BaseActivity
import com.kotlin.basecode.databinding.ActivityLoginBinding

/**
 * Activity displaying the login screen
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {
    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.loginPresenter = presenter

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun instantiatePresenter(): LoginPresenter {
        return LoginPresenter(this)
    }

    override fun showFieldError(id: String) {
        Toast.makeText(this, id, Toast.LENGTH_LONG).show()
    }

}