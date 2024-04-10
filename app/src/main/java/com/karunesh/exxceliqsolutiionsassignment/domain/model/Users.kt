package com.karunesh.exxceliqsolutiionsassignment.domain.model

/**
 * The Users data class represents a collection of user data along with pagination and support information.
 * It encapsulates properties such as user data, current page number, items per page, support details,
 * total number of users, and total number of pages.
 *
 * @property data The list of user data.
 * @property page The current page number of the user data.
 * @property per_page The number of items per page.
 * @property support The support information associated with the user data.
 * @property total The total number of users.
 * @property total_pages The total number of pages.
 *
 * Example Usage:
 * ```
 * val usersData = Users(
 *     data = listOf(userData1, userData2),
 *     page = 1,
 *     per_page = 10,
 *     support = supportInfo,
 *     total = 100,
 *     total_pages = 10
 * )
 * ```
 *
 * @see Support
 * @see Data
 */
data class Users(
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)