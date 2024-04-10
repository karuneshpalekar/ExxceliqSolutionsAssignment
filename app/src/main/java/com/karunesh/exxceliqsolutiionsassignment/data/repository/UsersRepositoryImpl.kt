package com.karunesh.exxceliqsolutiionsassignment.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.karunesh.exxceliqsolutiionsassignment.data.local.database.UserDatabase
import com.karunesh.exxceliqsolutiionsassignment.data.remote.api.Api
import com.karunesh.exxceliqsolutiionsassignment.data.repository.paging.UsersRemoteMediator
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Data
import com.karunesh.exxceliqsolutiionsassignment.domain.repository.UsersRepository
import com.karunesh.exxceliqsolutiionsassignment.util.RepositoryHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * The UsersRepositoryImpl class implements the UsersRepository interface and provides methods for
 * retrieving user data from a remote API and a local database.
 *
 * @param api The API service interface for fetching remote user data.
 * @param database The local user database for caching user data.
 */
class UsersRepositoryImpl(
    private val api: Api,
    private val database: UserDatabase
) : UsersRepository, RepositoryHelper() {

    /**
     * Retrieves a flow of paginated user data from the remote API and local database.
     *
     * @param pageSize The number of users to be loaded per page.
     * @return A flow of PagingData containing user data.
     */
    @OptIn(ExperimentalPagingApi::class)
    override fun getUsers(pageSize: Int): Flow<PagingData<Data>> {
        // Define the paging source factory using the user DAO from the database
        val pagingSourceFactory = { database.userDao().getUsers() }

        // Create a Pager with a remote mediator and map the database entities to data objects
        return Pager(
            config = PagingConfig(pageSize = pageSize),
            remoteMediator = UsersRemoteMediator(api, database),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { user ->
                user.toData()
            }
        }

    }

}