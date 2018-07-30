package com.kotlin.basecode.network

import com.kotlin.basecode.model.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.DELETE




/**
 * The interface which provides methods to get result of webservices
 */
interface UserApi {
    /**
     * Get the list of user
     */
    @GET("users")
    fun getUsers(): Observable<List<User>>

    /**
     * Save a new user
     */
    @POST("users")
    @FormUrlEncoded
    fun createUsers(@Field("firstName") firstName: String,
                    @Field("lastName") lastName: String,
                    @Field("emailAddress") emailAddress: String,
                    @Field("contactNo") contactNo: String): Call<User>

    /**
     * Update a user
     */
    @PUT("/users/{id}")
    @FormUrlEncoded
    fun updateUsers(@Path("id") id: Long,
                   @Field("firstName") firstName: String,
                   @Field("lastName") lastName: String,
                   @Field("emailAddress") emailAddress: String,
                   @Field("contactNo") contactNo: String): Call<User>

    /**
     * Deleting a user
     */
    @DELETE("/users/{id}")
    fun deleteUser(@Path("id") id: Long): Call<User>

}