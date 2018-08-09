package com.kotlin.basecode.network

import com.kotlin.basecode.model.User
import io.reactivex.Observable
import retrofit2.http.*


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
     * Get the user
     */
    @GET("users/{id}")
    fun getUsers(@Path("id") id: Long): Observable<User>

    /**
     * Save a new user
     */
    @POST("users")
    @FormUrlEncoded
    fun createUsers(@Field("firstName") firstName: String,
                    @Field("lastName") lastName: String,
                    @Field("emailAddress") emailAddress: String,
                    @Field("contactNo") contactNo: String): Observable<Boolean>

    /**
     * Update a user
     */
    @PUT("users/{id}")
    @FormUrlEncoded
    fun updateUsers(@Path("id") id: Long,
                   @Field("firstName") firstName: String,
                   @Field("lastName") lastName: String,
                   @Field("emailAddress") emailAddress: String,
                   @Field("contactNo") contactNo: String): Observable<Boolean>

    /**
     * Deleting a user
     */
    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id: Long): Observable<Boolean>


    /**
     * Verify Login User
     * Note: This is just for demo purposes.
     */
    @GET("users?email={email}&password={password}")
    fun verifyUserLogin(@Path("email")email: String,
                        @Path("password")password: String): Observable<Boolean>

}