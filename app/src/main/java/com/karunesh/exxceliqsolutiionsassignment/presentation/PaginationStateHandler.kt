package com.karunesh.exxceliqsolutiionsassignment.presentation

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

/**
 * The PaginationStateHandler composable function is responsible for handling the loading and error states
 * of a LazyPagingItems instance. It provides a customizable way to display loading indicators and error messages
 * based on the current state of pagination.
 *
 * @param paginationState The LazyPagingItems representing the pagination state.
 * @param loadingComponent The composable function to be displayed when the pagination is in a loading state.
 * @param errorComponent The optional composable function to be displayed when an error occurs during pagination.
 *                       It accepts a function parameter that handles the error, allowing custom error handling.
 *                       If not provided, errors will not be displayed.
 *
 * Example Usage:
 * ```
 * PaginationStateHandler(
 *     paginationState = userState,
 *     loadingComponent = {
 *         Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
 *             CircularProgressIndicator()
 *         }
 *     },
 *     errorComponent = { error ->
 *         ErrorMessage(text = error.message ?: "Unknown error occurred")
 *     }
 * )
 * ```
 *
 * @see androidx.paging.compose.LazyPagingItems
 * @see androidx.compose.runtime.Composable
 * @see androidx.paging.LoadState.Loading
 * @see androidx.paging.LoadState.Error
 */
@Composable
fun <T : Any> PaginationStateHandler(
    paginationState: LazyPagingItems<T>,
    loadingComponent: @Composable () -> Unit,
    errorComponent: @Composable ((Throwable) -> Unit)? = null
) {
    // Apply different UI components based on the current load state of pagination
    paginationState.apply {
        when {
            (loadState.refresh is LoadState.Loading)
                    or (loadState.append is LoadState.Loading)
                    or (loadState.prepend is LoadState.Loading) -> loadingComponent()

            (loadState.refresh is LoadState.Error) -> {
                errorComponent?.invoke((loadState.refresh as LoadState.Error).error)
            }
            (loadState.append is LoadState.Error) -> {
                errorComponent?.invoke((loadState.append as LoadState.Error).error)
            }
            (loadState.prepend is LoadState.Error) -> {
                errorComponent?.invoke((loadState.prepend as LoadState.Error).error)
            }
        }
    }

}