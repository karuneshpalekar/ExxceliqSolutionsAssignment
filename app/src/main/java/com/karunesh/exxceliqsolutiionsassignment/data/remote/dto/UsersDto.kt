package com.karunesh.exxceliqsolutiionsassignment.data.remote.dto

import android.os.Parcelable
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Users
import kotlinx.parcelize.Parcelize

/**
 * The UsersDto data class represents a Users transfer object (DTO) containing user-related information.
 * It encapsulates properties such as user data list, page information, support information, and total counts.
 *
 * @property data The list of DataDto objects representing user data.
 * @property page The current page number of the user data.
 * @property per_page The number of items per page.
 * @property support The SupportDto object containing support information.
 * @property total The total number of users.
 * @property total_pages The total number of pages.
 *
 * Example Usage:
 * ```
 * val usersDto = UsersDto(
 *     data = listOf(userDataDto1, userDataDto2),
 *     page = 1,
 *     per_page = 10,
 *     support = supportDto,
 *     total = 100,
 *     total_pages = 10
 * )
 * ```
 *
 * @see kotlinx.parcelize.Parcelize
 * @see kotlinx.android.parcel.Parcelize
 */
@Parcelize
data class UsersDto(
    val data: List<DataDto>,
    val page: Int,
    val per_page: Int,
    val support: SupportDto,
    val total: Int,
    val total_pages: Int
) : Parcelable {

    /**
     * Converts the UsersDto object to a Users object.
     *
     * @return A Users object representing the converted user-related information.
     */
    fun toUsers(): Users {
        return Users(
            data = data.map { data ->
                data.toData(page)
            },
            page = page,
            per_page = per_page,
            support = support.toSupport(),
            total = total,
            total_pages = total_pages
        )
    }

}