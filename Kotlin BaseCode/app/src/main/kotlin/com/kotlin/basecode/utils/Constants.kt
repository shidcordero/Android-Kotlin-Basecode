package com.kotlin.basecode.utils

/** The base URL of the API */

class Constants{

    class Environment {
        companion object {
            const val BASE_URL: String = "https://my-json-server.typicode.com/shidcordero12/android-json-server/"
        }
    }

    class Common {
        companion object {
            const val REQUEST_READ_CONTACTS = 0
            const val PASSWORD_LENGTH = 5
            const val EMAIL_REGEX = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        }
    }

    class Tag {
        companion object {
            const val SPLASH_SCREEN_TAG = "SplashScreenActivity.Tag"
        }
    }
}
