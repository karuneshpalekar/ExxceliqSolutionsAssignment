package com.karunesh.exxceliqsolutiionsassignment.domain.usecase

/**
 * The UsersUseCases data class encapsulates user-related use cases.
 * It provides a convenient way to access various operations related to user data.
 *
 * @param getUsers The use case for retrieving a paginated list of users.
 */
data class UsersUseCases(
    val getUsers: GetUsers
)