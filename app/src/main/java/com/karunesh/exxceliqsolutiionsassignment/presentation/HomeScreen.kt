package com.karunesh.exxceliqsolutiionsassignment.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.karunesh.exxceliqsolutiionsassignment.R

/**
 * The HomeScreen composable function represents the UI component responsible for displaying the home screen
 * of the application. It receives a [viewModel] parameter of type [HomeViewModel] to interact with the data
 * associated with the home screen.
 *
 * @param viewModel The view model responsible for providing data to the home screen.
 *
 * Example Usage:
 * ```
 * HomeScreen(viewModel = homeViewModel)
 * ```
 *
 * @see androidx.compose.runtime.Composable
 * @see androidx.paging.compose.collectAsLazyPagingItems
 * @see androidx.compose.foundation.layout.fillMaxSize
 * @see androidx.compose.foundation.layout.padding
 * @see androidx.compose.foundation.layout.Arrangement
 * @see androidx.compose.foundation.layout.lazy.LazyColumn
 * @see androidx.compose.foundation.layout.Box
 * @see androidx.compose.foundation.layout.fillMaxWidth
 * @see androidx.compose.material.CircularProgressIndicator
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
) {

    // Collects the user state from the view model as lazy paging items
    val userState = viewModel.usersState
        .collectAsLazyPagingItems()

    /**
     * Represents a composable function to display an error message with a retry option.
     */
    @Composable
    fun ErrorMessage() {
        WarningMessage(
            text = "",
            trailingContent = {
                Text(
                    text = stringResource(id = R.string.retry),
                    modifier = Modifier
                        .padding(start = 3.dp)
                        .clickable(role = Role.Button) { userState.retry() },
                    color = MaterialTheme.colors.onBackground
                )
            }
        )
    }

    // Constructs the UI using a LazyColumn
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 2.dp),
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxSize()
    ) {


        // Iterates through the user items and displays UserProfile composable for each user
        items(userState.itemCount) { index ->
            val user = userState[index]
            if (user != null) {
                UserProfile(data = user)
            } else {
                ErrorMessage()
            }
        }

        // Displays a PaginationStateHandler to handle loading and error states
        item {
            PaginationStateHandler(
                paginationState = userState,
                loadingComponent = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                },
                errorComponent = {
                    ErrorMessage()
                }
            )
        }
    }


}

