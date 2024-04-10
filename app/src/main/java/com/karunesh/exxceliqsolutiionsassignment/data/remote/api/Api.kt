package com.karunesh.exxceliqsolutiionsassignment.data.remote.api

import com.karunesh.exxceliqsolutiionsassignment.data.remote.dto.UsersDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * The Api interface defines methods for interacting with the remote API to fetch user-related data.
 */
interface Api {

    /**
     *  Get The list of Users with pagination
     *
     *  @param page [Int] page number to be fetched
     *  @return [List]<[UsersDto]>
     */
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int
    ): UsersDto

}