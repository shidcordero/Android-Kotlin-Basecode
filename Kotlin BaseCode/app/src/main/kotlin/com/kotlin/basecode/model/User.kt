package com.kotlin.basecode.model

/**
 * Class which provides a model for user
 * @constructor Sets all properties of the user
 * @property id the unique identifier of the user
 * @property firstName the first name of the user
 * @property lastName the last name of the user
 * @property email the email of the user
 * @property contactNo the contact number of the user
 */
data class User(val id: Int, val firstName: String, val lastName: String, val email: String, val contactNo: String){
    fun toFullName(): String {
        return "$firstName $lastName"
    }
}