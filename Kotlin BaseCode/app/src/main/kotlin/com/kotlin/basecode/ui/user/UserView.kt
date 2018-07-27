package com.kotlin.basecode.ui.user

import android.support.annotation.StringRes
import com.kotlin.basecode.base.BaseView
import com.kotlin.basecode.model.User

/**
 * Interface providing required method for a view displaying users
 */
interface UserView : BaseView {
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
     * Updates the previous users by the specified ones
     * @param users the list of user that will replace existing ones
     */
    fun updateUsers(users: List<User>)

    /**
     * Displays the loading indicator of the view
     */
    fun showLoading()

    /**
     * Hides the loading indicator of the view
     */
    fun hideLoading()
}