package com.karunesh.exxceliqsolutiionsassignment.data.repository.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.karunesh.exxceliqsolutiionsassignment.data.local.database.UserDatabase
import com.karunesh.exxceliqsolutiionsassignment.data.local.entity.UserEntity
import com.karunesh.exxceliqsolutiionsassignment.data.remote.api.Api

/**
 * The UsersRemoteMediator class is responsible for mediating data loading from the remote API
 * for pagination in combination with the local database.
 *
 * @param api The API service interface for fetching remote user data.
 * @param database The local user database for caching user data.
 */
@OptIn(ExperimentalPagingApi::class)
class UsersRemoteMediator(
    private val api: Api,
    private val database: UserDatabase
) : RemoteMediator<Int, UserEntity>() {

    // Maximum page limit for data loading
    private val maxPage = 5

    // Current page loaded from the API
    private var currentPage: Int? = 0


    /**
     * Loads data from the remote API and updates the local database accordingly.
     *
     * @param loadType The type of data loading operation (refresh, prepend, append).
     * @param state The current paging state containing information about the data being loaded.
     * @return A MediatorResult indicating the result of the data loading operation.
     */
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UserEntity>
    ): MediatorResult {
        try {
            // Determine the page to load based on loadType
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    1
                }

                LoadType.PREPEND -> {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }

                LoadType.APPEND -> {
                    // Load the next page
                    val lastPage = currentPage ?: return MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                    lastPage + 1
                }
            }

            // If the page exceeds maxPage, return endOfPaginationReached = true
            if (page > maxPage) {
                return MediatorResult.Success(endOfPaginationReached = true)
            }


            // Fetch data from the network
            val response = api.getUsers(page)
            val usersList = response.data.map { it.toData(page) }
            currentPage = response.page

            // Insert data into the database
            database.withTransaction {
                database.userDao().insertAll(usersList.map {
                    it.toUser()
                })
            }
            // Return success if end of pagination is reached
            return MediatorResult.Success(endOfPaginationReached = response.page == response.total_pages)

        } catch (exp: Exception) {
            // Return error if an exception occurs during data loading
            return MediatorResult.Error(exp)
        }
    }
}
