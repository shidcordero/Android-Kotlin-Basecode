package com.kotlin.basecode.ui.login

import android.support.annotation.StringRes
import android.view.View
import com.kotlin.basecode.base.BaseView
import com.kotlin.basecode.model.User

/**
 * Interface providing required method for a view displaying login screen
 */
interface LoginView : BaseView {

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
     * Displays a field error in the field
     * @param focusView the view the error will display
     */
    fun showFieldError(id: String)


}