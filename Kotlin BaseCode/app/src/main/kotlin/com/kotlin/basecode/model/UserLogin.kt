package com.kotlin.basecode.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.kotlin.basecode.BR

/**
 * Class which provides a model for user
 * @constructor Sets all properties of the user
 * @property email the email of the user
 * @property password the password of the user
 */
class UserLogin : BaseObservable() {

    companion object {
        fun build (email:String, password: String): UserLogin {
            val user = UserLogin()
            user.email = email
            user.password = password

            return user
        }
    }

    @Bindable
    var email: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    @Bindable
    var password: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.password)
        }
}