package com.karunesh.exxceliqsolutiionsassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * The BaseApplication class represents the base application class for the HiltAndroidApp.
 * This class extends the Android Application class, serving as the entry point for the application's lifecycle.
 * It is annotated with @HiltAndroidApp, indicating that Hilt should generate the necessary components
 * for dependency injection.
 *
 * This class is typically used to initialize application-wide resources, set up configurations,
 * and manage the overall application lifecycle.
 *
 * Example Usage:
 * ```
 * // Extends BaseApplication in your application class.
 * public class MyApplication extends BaseApplication {
 *     // Additional application-specific code can be added here.
 * }
 * ```
 *
 * @see android.app.Application
 * @see dagger.hilt.android.HiltAndroidApp
 */
@HiltAndroidApp
class BaseApplication: Application()