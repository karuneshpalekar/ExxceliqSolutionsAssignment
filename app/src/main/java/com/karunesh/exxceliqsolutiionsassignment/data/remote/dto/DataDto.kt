package com.karunesh.exxceliqsolutiionsassignment.data.remote.dto

import android.os.Parcelable
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Data
import kotlinx.parcelize.Parcelize

/**
 * The DataDto data class represents a Data transfer object (DTO) containing user data fields.
 * It encapsulates properties such as avatar URL, email, first name, last name, and ID.
 *
 * @property avatar The URL of the user's avatar image.
 * @property email The email address of the user.
 * @property first_name The first name of the user.
 * @property id The unique identifier of the user.
 * @property last_name The last name of the user.
 *
 * Example Usage:
 * ```
 * val userDataDto = DataDto(
 *     avatar = "https://example.com/avatar.jpg",
 *     email = "user@example.com",
 *     first_name = "John",
 *     id = 123,
 *     last_name = "Doe"
 * )
 * ```
 *
 * @see kotlinx.parcelize.Parcelize
 * @see kotlinx.android.parcel.Parcelize
 */
@Parcelize
data class DataDto(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String,
) : Parcelable {

    /**
     * Converts the DataDto object to a Data object with an additional page number.
     *
     * @param page The page number associated with the data.
     * @return A Data object representing the converted user data.
     */
    fun toData(page : Int): Data {
        return Data(
            avatar = avatar,
            email = email,
            first_name = first_name,
            id = id,
            last_name = last_name,
            page = page
        )
    }

}