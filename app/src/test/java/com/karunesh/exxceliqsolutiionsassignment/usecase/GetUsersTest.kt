package com.karunesh.exxceliqsolutiionsassignment.usecase

import androidx.paging.PagingData
import com.karunesh.exxceliqsolutiionsassignment.data.local.entity.UserEntity
import com.karunesh.exxceliqsolutiionsassignment.domain.repository.UsersRepository
import com.karunesh.exxceliqsolutiionsassignment.domain.usecase.GetUsers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.doReturn
import org.mockito.kotlin.mock


class GetUsersTest {

    private lateinit var getUsers: GetUsers
    private lateinit var userRepository: UsersRepository

    @Before
    fun setUp() {
        userRepository = mock()
        getUsers = GetUsers(userRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test getUsers use case`() = runBlockingTest {
        // Given
        val pageSize = 10
        val mockPagingData = PagingData.from(listOf(
            UserEntity(1, "user1@example.com", "John", "Doe", "avatar1", 1),
            UserEntity(2, "user2@example.com", "Jane", "Smith", "avatar2", 1)
        ))
        val mockFlow = flowOf(mockPagingData)

        // Mock the behavior of the repository
        userRepository.apply {
            doReturn(mockFlow).`when`(this).getUsers(pageSize)
        }

        // When
        val result = getUsers(pageSize).toList()

        // Then
        assertEquals(1, result.size)
        assertEquals(mockPagingData, result.first())
    }
}


