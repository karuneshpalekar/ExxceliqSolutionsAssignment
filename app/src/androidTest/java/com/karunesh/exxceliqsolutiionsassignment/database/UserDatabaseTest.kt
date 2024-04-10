package com.karunesh.exxceliqsolutiionsassignment.database


import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.karunesh.exxceliqsolutiionsassignment.data.local.dao.UserDao
import com.karunesh.exxceliqsolutiionsassignment.data.local.database.UserDatabase
import com.karunesh.exxceliqsolutiionsassignment.data.local.entity.UserEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

class UserDatabaseTest {

    private lateinit var userDao: UserDao
    private lateinit var db: UserDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().context
        db = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
        userDao = db.userDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndRetrieveUser() = runBlocking {
        // Given
        val user = UserEntity(1, "john@example.com", "John", "Doe", "avatar1", 1)

        val userList = listOf<UserEntity>(user)
        // When
        userDao.insertAll(userList)
        val retrievedUser = userDao.getUsers()
        // Then
        assertEquals(userList, retrievedUser)
    }


}
