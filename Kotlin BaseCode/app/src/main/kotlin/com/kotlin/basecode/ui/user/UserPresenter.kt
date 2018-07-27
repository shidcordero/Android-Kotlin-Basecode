package com.kotlin.basecode.ui.user

import com.kotlin.basecode.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.kotlin.basecode.R
import com.kotlin.basecode.network.UserApi
import javax.inject.Inject



/**
 * The Presenter that will present the User view.
 * @param userView the User view to be presented by the presenter
 * @property userApi the API interface implementation
 * @property subscription the subscription to the API call
 */
class UserPresenter(userView: UserView) : BasePresenter<UserView>(userView) {
    @Inject
    lateinit var userApi: UserApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadUsers()
    }

    /**
     * Loads the users from the API and presents them in the view when retrieved, or shows error if
     * any.
     */
    private fun loadUsers() {
        view.showLoading()

        subscription = userApi
                .getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { userList -> view.updateUsers(userList) },
                        { view.showError(R.string.error_processing) }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}