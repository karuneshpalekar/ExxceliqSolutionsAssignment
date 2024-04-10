package com.karunesh.exxceliqsolutiionsassignment.repository


import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.karunesh.exxceliqsolutiionsassignment.data.local.database.UserDatabase
import com.karunesh.exxceliqsolutiionsassignment.data.local.entity.UserEntity
import com.karunesh.exxceliqsolutiionsassignment.data.remote.api.Api
import com.karunesh.exxceliqsolutiionsassignment.data.remote.dto.DataDto
import com.karunesh.exxceliqsolutiionsassignment.data.remote.dto.SupportDto
import com.karunesh.exxceliqsolutiionsassignment.data.remote.dto.UsersDto
import com.karunesh.exxceliqsolutiionsassignment.data.repository.UsersRepositoryImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class UsersRepositoryImplTest {

    private lateinit var repository: UsersRepositoryImpl
    private val mockApi = mock<Api>()
    private val mockDatabase: UserDatabase = mock()

    @Before
    fun setUp() {
        repository = UsersRepositoryImpl(mockApi, mockDatabase)
    }

    @Test
    fun getUsers_Success() = runBlocking {
        // Given
        val testData = createTestData() // Create test data
        val mockPagingData = PagingData.from(testData.data.map { it.toUserEntity() })
        whenever(mockDatabase.userDao().getUsers()).thenReturn(mockPagingSource())
        whenever(mockApi.getUsers(1)).thenReturn(testData)

        // When
        val result = repository.getUsers(1)

        // Then
        val collectedPagingData = result.first()
        assertEquals(mockPagingData, collectedPagingData)
    }

    private fun createTestData(): UsersDto {
        // Create test data
        return UsersDto(
            data = listOf(
                DataDto("avatar1", "user1@example.com", "John", 1, "Doe"),
                DataDto("avatar2", "user2@example.com", "Jane", 2, "Smith")
            ),
            page = 1,
            per_page = 10,
            support = SupportDto("Support", "http://example.com"),
            total = 2,
            total_pages = 1
        )
    }

    private fun mockPagingSource(): PagingSource<Int, UserEntity>? {
        return mock()
    }

    private fun DataDto.toUserEntity(): UserEntity {
        return UserEntity(
            id = id,
            email = email,
            firstName = first_name,
            lastName = last_name,
            avatar = avatar,
            page = 1 // Adjust as needed
        )
    }
}