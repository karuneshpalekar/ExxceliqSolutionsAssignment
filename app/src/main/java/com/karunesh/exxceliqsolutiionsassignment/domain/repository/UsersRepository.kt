package com.karunesh.exxceliqsolutiionsassignment.domain.repository

import androidx.paging.PagingData
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Data
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Users
import kotlinx.coroutines.flow.Flow

/**
 * The UsersRepository interface defines methods for fetching user data from a remote data source.
 * It provides a way to retrieve a list of users with pagination.
 */
interface UsersRepository {

    /**
     *  Get the list of users with pagination from a remote data source
     *
     *  @param pageSize [Int] The amount of users to be loaded  per page
     *  @return [Flow]<[PagingData]<[Users]>>
     */
    fun getUsers(pageSize: Int): Flow<PagingData<Data>>


}