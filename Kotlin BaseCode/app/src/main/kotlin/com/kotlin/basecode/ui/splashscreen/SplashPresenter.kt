package com.kotlin.basecode.ui.splashscreen

import com.kotlin.basecode.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit


/**
 * The Presenter that will present the User view.
 * @param splashView the Splash view to be presented by the presenter
 * @property subscription the subscription to the API call
 */
class SplashPresenter(splashView: SplashView) : BasePresenter<SplashView>(splashView) {
    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadData()
    }

    /**
     * Loads the users from the API and presents them in the view when retrieved, or shows error if
     * any.
     */
    private fun loadData() {
        Observable.intervalRange(0L, 50L, 10, 10, TimeUnit.MILLISECONDS,
                AndroidSchedulers.mainThread())
                .subscribe { view.updateProgress() }
//        subscription = userApi
//                .getUsers()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .doOnTerminate { view.hideLoading() }
//                .subscribe(
//                        { userList -> view.updateUsers(userList) },
//                        { view.showError(R.string.error_processing) }
//                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}