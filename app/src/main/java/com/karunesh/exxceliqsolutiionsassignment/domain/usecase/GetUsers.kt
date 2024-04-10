package com.karunesh.exxceliqsolutiionsassignment.domain.usecase

import androidx.paging.PagingData
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Data
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Users
import com.karunesh.exxceliqsolutiionsassignment.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow

/**
 * The GetUsers class encapsulates the logic for retrieving a paginated list of users from a repository.
 * It acts as a use case by providing a clean and concise way to fetch user data.
 *
 * @param repository The repository responsible for fetching user data.
 */
class GetUsers(private val repository: UsersRepository) {

    /**
     * Invokes the use case to fetch users data.
     *
     * @param pageSize The number of users to be loaded per page.
     * @return A Flow of PagingData containing user data.
     */
    operator fun invoke(pageSize: Int): Flow<PagingData<Data>> {
        return repository.getUsers(pageSize = pageSize)
    }

}