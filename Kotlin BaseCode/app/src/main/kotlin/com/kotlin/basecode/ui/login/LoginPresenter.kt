package com.kotlin.basecode.ui.login

import com.kotlin.basecode.base.BasePresenter
import com.kotlin.basecode.network.UserApi
import com.kotlin.basecode.model.UserLogin
import io.reactivex.disposables.Disposable
import javax.inject.Inject


/**
 * The Presenter that will present the User view.
 * @param loginView the Login view to be presented by the presenter
 * @property subscription the subscription to the API call
 */
class LoginPresenter(loginView: LoginView) : BasePresenter<LoginView>(loginView) {
    @Inject
    lateinit var userApi: UserApi

    var userLogin: UserLogin= UserLogin.build("","")

    private var subscription: Disposable? = null


    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    /**
     * Validates the users from the API and presents them in the view when retrieved, or shows error if
     * not found.
     */

    fun verifyUser() {
        view.showFieldError(userLogin.email)
    }


}