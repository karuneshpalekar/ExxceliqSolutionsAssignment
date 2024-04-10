package com.karunesh.exxceliqsolutiionsassignment.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.karunesh.exxceliqsolutiionsassignment.data.local.dao.UserDao
import com.karunesh.exxceliqsolutiionsassignment.data.local.entity.UserEntity

/**
 * The UserDatabase class represents the local database for storing user-related data.
 *
 * @see androidx.room.Database
 */
@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    /**
     * Retrieves the UserDao instance for accessing user-related database operations.
     *
     * @return A UserDao instance for accessing user-related database operations.
     */
    abstract fun userDao(): UserDao
}