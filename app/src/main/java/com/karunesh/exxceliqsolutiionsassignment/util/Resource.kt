package com.karunesh.exxceliqsolutiionsassignment.util

/**
 * The Resource sealed class represents a data holder class that encapsulates the different states
 * of a data operation such as success, loading, or error. It is commonly used in asynchronous
 * data operations, such as network requests, to provide a consistent and structured way of
 * handling and communicating the state and result of the operation.
 *
 * @param T The type of data that the resource holds.
 * @property data The data associated with the resource. It can be null depending on the state.
 * @property error The error associated with the resource, if any. It can be null if there is no error.
 *
 * Example Usage:
 * ```
 * // Create a Success resource with data
 * val successResource = Resource.Success(data)
 *
 * // Create a Loading resource
 * val loadingResource = Resource.Loading()
 *
 * // Create an Error resource with optional data and error
 * val errorResource = Resource.Error(data, error)
 * ```
 *
 * @see kotlin.Throwable
 */
sealed class Resource<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    /**
     * Represents the success state of a resource operation, holding the successful data.
     *
     * @param data The successful data associated with the resource.
     */
    class Success<T>(data: T): Resource<T>(data = data)

    /**
     * Represents the loading state of a resource operation.
     *
     * @param data Optional data associated with the resource, typically null during loading.
     */
    class Loading<T>(data: T? = null): Resource<T>(data = data)

    /**
     * Represents the error state of a resource operation, holding optional data and error information.
     *
     * @param data Optional data associated with the resource, typically null in case of error.
     * @param error The error associated with the resource operation, if any.
     */
    class Error<T>(data: T? = null, error: Throwable? = null): Resource<T>(data = data, error = error)
}