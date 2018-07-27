package com.kotlin.basecode.network

import com.kotlin.basecode.model.User
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface UserApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/users")
    fun getUsers(): Observable<List<User>>
}