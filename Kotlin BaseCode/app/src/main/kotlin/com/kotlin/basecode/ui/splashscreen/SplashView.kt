package com.kotlin.basecode.ui.splashscreen

import android.support.annotation.StringRes
import com.kotlin.basecode.base.BaseView
import com.kotlin.basecode.model.User

/**
 * Interface providing required method for a view displaying splash screen
 */
interface SplashView : BaseView {

    /**
     * Displays an error in the view
     * @param error the error to display in the view
     */
    fun showError(error: String)

    /**
     * Displays an error in the view
     * @param errorResId the resource id of the error to display in the view
     */
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    /**
     * Updates the previous posts by the specified ones
     */
    fun updateProgress()

    /**
     * Displays the loading indicator of the view
     */
    fun intentLogin()


}