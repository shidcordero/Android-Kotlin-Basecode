package com.kotlin.basecode.ui.splashscreen

import com.kotlin.basecode.R
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

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    /**
     * Loads the users from the API and presents them in the view when retrieved, or shows error if
     * any.
     * Note: This is just a simulation for Loading Screen, change this to api call if you
     * get data from a Web Service
     */
    private fun loadData() {
        Observable.intervalRange(0, 10, 1000, 1000,
                    TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .doOnComplete{view.intentLogin()}
                .subscribe(
                        { view.updateProgress() },
                        { view.showError(R.string.error_processing)}
                )
    }

}