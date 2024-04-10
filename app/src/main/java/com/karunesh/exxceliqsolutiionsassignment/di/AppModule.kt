package com.karunesh.exxceliqsolutiionsassignment.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.karunesh.exxceliqsolutiionsassignment.BaseApplication
import com.karunesh.exxceliqsolutiionsassignment.data.local.database.UserDatabase
import com.karunesh.exxceliqsolutiionsassignment.data.remote.api.Api
import com.karunesh.exxceliqsolutiionsassignment.data.repository.UsersRepositoryImpl
import com.karunesh.exxceliqsolutiionsassignment.domain.repository.UsersRepository
import com.karunesh.exxceliqsolutiionsassignment.domain.usecase.GetUsers
import com.karunesh.exxceliqsolutiionsassignment.domain.usecase.UsersUseCases
import com.karunesh.exxceliqsolutiionsassignment.util.ApiBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * The AppModule object provides Dagger Hilt modules for dependency injection within the application.
 * It defines the singleton-scoped dependencies required by the application.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Provides the singleton instance of the BaseApplication.
     *
     * @param app The application context.
     * @return The singleton instance of BaseApplication.
     */
    @Singleton
    @Provides
    fun providesTvManiaApplication(
        @ApplicationContext app: Context
    ): BaseApplication {
        return app as BaseApplication
    }

    /**
     * Provides the API instance using the ApiBuilder.
     *
     * @param apiBuilder The API builder instance.
     * @return The API instance.
     */
    @Singleton
    @Provides
    fun providesApi(apiBuilder: ApiBuilder): Api {
        return apiBuilder.builder(api = Api::class.java)
    }


    /**
     * Provides the singleton instance of the UsersRepository.
     *
     * @param api The API instance.
     * @param database The user database instance.
     * @return The singleton instance of UsersRepository.
     */
    @Singleton
    @Provides
    fun providesUsersRepository(api: Api, database: UserDatabase): UsersRepository {
        return UsersRepositoryImpl(
            api = api,
            database = database
        )
    }

    /**
     * Provides the singleton instance of the UsersUseCases.
     *
     * @param repository The repository instance.
     * @return The singleton instance of UsersUseCases.
     */
    @Singleton
    @Provides
    fun providesTvShowUseCases(repository: UsersRepository): UsersUseCases {
        return UsersUseCases(
            getUsers = GetUsers(repository = repository)
        )
    }

    /**
     * Provides the singleton instance of the UserDatabase.
     *
     * @param application The application instance.
     * @return The singleton instance of UserDatabase.
     */
    @Singleton
    @Provides
    fun providesUserDatabase(application: Application): UserDatabase {
        return Room.databaseBuilder(
            application,
            UserDatabase::class.java,
            "UserDatabase"
        ).fallbackToDestructiveMigration()
            .build()
    }
}