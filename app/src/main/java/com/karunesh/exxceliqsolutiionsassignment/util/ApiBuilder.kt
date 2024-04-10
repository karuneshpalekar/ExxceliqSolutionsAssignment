package com.karunesh.exxceliqsolutiionsassignment.util

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * The ApiBuilder class is responsible for building Retrofit API instances with predefined configurations.
 * It utilizes Dagger/Hilt for dependency injection and constructs instances of Retrofit APIs.
 *
 * @property api: An instance of Retrofit.Builder() configured with the base URL, OkHttpClient,
 *                and GsonConverterFactory.
 * @property getClient: A private method that constructs and configures OkHttpClient
 *                      with timeout settings and custom interceptors for HTTP requests.
 *
 * Example Usage:
 * ```
 * val apiBuilder = ApiBuilder()
 * val myApiService = apiBuilder.builder(MyApiService::class.java)
 * ```
 *
 * @see okhttp3.OkHttpClient
 * @see retrofit2.Retrofit
 * @see retrofit2.converter.gson.GsonConverterFactory
 * @see dagger.hilt.android.HiltAndroidApp
 * @see javax.inject.Inject
 */

class ApiBuilder @Inject constructor() {

    /**
     * Constructs an instance of a Retrofit API based on the provided API interface.
     *
     * @param api: The interface class representing the API.
     * @return An instance of the specified Retrofit API.
     */
    fun <Api> builder(api: Class<Api>): Api {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

    /**
     * Constructs and configures an OkHttpClient with timeout settings and custom interceptors.
     *
     * @return A configured instance of OkHttpClient.
     */
    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().also {
                        it.addHeader("X-Requested-With", "XMLHttpRequest")
                            .addHeader("content-type", "application/json")
                    }.build()
                )
            }.also { client ->
                client.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MINUTES)
                    .readTimeout(READ_TIMEOUT, TimeUnit.MINUTES)
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            }.build()
    }
}