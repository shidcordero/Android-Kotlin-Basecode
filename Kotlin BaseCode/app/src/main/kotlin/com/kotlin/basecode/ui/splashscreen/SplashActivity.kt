package com.kotlin.basecode.ui.splashscreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import com.kotlin.basecode.R
import com.kotlin.basecode.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import com.kotlin.basecode.databinding.ActivitySplashScreenBinding

/**
 * Activity displaying the splash screen
 */
class SplashActivity : BaseActivity<SplashPresenter>(), SplashView {

    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)
        binding.pleaseWaitText = getString(R.string.loading_wait1)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun updateProgress() {
        binding.pleaseWaitText = when (loadingText.text){
            getString(R.string.loading_wait1) -> {
                getString(R.string.loading_wait2)
            }
            getString(R.string.loading_wait2) -> {
                getString(R.string.loading_wait3)
            }
            else -> {
                getString(R.string.loading_wait1)
            }
        }
    }

    override fun intentLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun instantiatePresenter(): SplashPresenter {
        return SplashPresenter(this)
    }

}