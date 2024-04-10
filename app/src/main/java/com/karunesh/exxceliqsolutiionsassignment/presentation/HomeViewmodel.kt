package com.karunesh.exxceliqsolutiionsassignment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Data
import com.karunesh.exxceliqsolutiionsassignment.domain.usecase.UsersUseCases
import com.karunesh.exxceliqsolutiionsassignment.util.PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * The HomeViewModel class is responsible for managing the UI-related data and business logic
 * for the home screen of the application. It interacts with the `UsersUseCases` to retrieve
 * user data and provides the data to the UI components observing its state.
 *
 * @param usersUseCases The use case class responsible for providing user-related operations.
 *
 * Example Usage:
 * ```
 * val homeViewModel = viewModel<HomeViewModel>()
 * ```
 *
 * @see androidx.lifecycle.ViewModel
 * @see kotlinx.coroutines.flow.MutableStateFlow
 * @see kotlinx.coroutines.flow.StateFlow
 * @see kotlinx.coroutines.flow.distinctUntilChanged
 * @see androidx.lifecycle.viewModelScope
 * @see kotlinx.coroutines.flow.collect
 * @see kotlinx.coroutines.flow.cachedIn
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val usersUseCases: UsersUseCases
) : ViewModel() {

    // MutableStateFlow to hold the current paging data of users
    private val _userState: MutableStateFlow<PagingData<Data>> =
        MutableStateFlow(value = PagingData.empty())

    // Exposed StateFlow representing the current paging data of users
    val usersState: StateFlow<PagingData<Data>>
        get() = _userState

    init {
        // Fetch users data and update _userState using coroutines
        viewModelScope.launch {
            usersUseCases.getUsers(pageSize = PAGE_SIZE)
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                    _userState.value = it
                }
        }
    }

}