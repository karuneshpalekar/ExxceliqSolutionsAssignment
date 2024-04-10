package com.karunesh.exxceliqsolutiionsassignment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Data

/**
 * The UserEntity class represents a user entity in the local database.
 *
 * @param id The unique identifier of the user.
 * @param email The email address of the user.
 * @param firstName The first name of the user.
 * @param lastName The last name of the user.
 * @param avatar The URL of the user's avatar image.
 * @param page The page number to keep track of pagination.
 *
 * Example Usage:
 * ```
 * val userEntity = UserEntity(
 *     id = 1,
 *     email = "user@example.com",
 *     firstName = "John",
 *     lastName = "Doe",
 *     avatar = "https://example.com/avatar.jpg",
 *     page = 1
 * )
 * ```
 *
 * @see androidx.room.Entity
 * @see androidx.room.PrimaryKey
 */
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val page: Int //  page number to keep track of pagination
) {

    /**
     * Converts the UserEntity object to a Data object.
     *
     * @return A Data object representing the converted user data.
     */
    fun toData(): Data {
        return Data(
            id = id,
            email = email,
            first_name = firstName,
            last_name = lastName,
            avatar = avatar,
            page = page
        )
    }
}