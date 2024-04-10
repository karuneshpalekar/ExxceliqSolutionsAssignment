package com.karunesh.exxceliqsolutiionsassignment.domain.model

import android.os.Parcelable
import com.karunesh.exxceliqsolutiionsassignment.data.local.entity.UserEntity
import kotlinx.parcelize.Parcelize

/**
 * The Data data class represents a model class for user data retrieved from a data source.
 * It encapsulates properties such as avatar URL, email, first name, last name, ID, and page number.
 *
 * @property avatar The URL of the user's avatar image.
 * @property email The email address of the user.
 * @property first_name The first name of the user.
 * @property id The unique identifier of the user.
 * @property last_name The last name of the user.
 * @property page The page number from which the user data is retrieved.
 *
 * Example Usage:
 * ```
 * val userData = Data(
 *     avatar = "https://example.com/avatar.jpg",
 *     email = "user@example.com",
 *     first_name = "John",
 *     id = 123,
 *     last_name = "Doe",
 *     page = 1
 * )
 * ```
 *
 * @see kotlinx.parcelize.Parcelize
 * @see kotlinx.android.parcel.Parcelize
 */
@Parcelize
data class Data(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String,
    val page: Int
) : Parcelable {

    fun toUser(): UserEntity {
        return UserEntity(
            avatar = avatar,
            email = email,
            firstName = first_name,
            id = id,
            lastName = last_name,
            page = page
        )
    }
}