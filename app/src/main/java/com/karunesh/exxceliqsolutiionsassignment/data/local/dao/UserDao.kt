package com.karunesh.exxceliqsolutiionsassignment.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karunesh.exxceliqsolutiionsassignment.data.local.entity.UserEntity

/**
 * The UserDao interface defines methods for accessing and manipulating user-related data in the local database.
 *
 * @see androidx.room.Dao
 */
@Dao
interface UserDao {
    /**
     * Retrieves a PagingSource of user entities from the database.
     *
     * @return A PagingSource containing user entities.
     */
    @Query("SELECT * FROM users")
    fun getUsers(): PagingSource<Int, UserEntity>

    /**
     * Inserts a list of user entities into the database.
     *
     * @param users The list of user entities to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(users: List<UserEntity>)

    /**
     * Clears all user entities from the database.
     */
    @Query("DELETE FROM users")
    suspend fun clearUsers()
}