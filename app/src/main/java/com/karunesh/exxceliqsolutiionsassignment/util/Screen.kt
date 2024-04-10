package com.karunesh.exxceliqsolutiionsassignment.util

/**
 * The Screen sealed class represents different screens or destinations within an application's navigation system.
 * It encapsulates the route or identifier associated with each screen.
 *
 * @param route The unique route or identifier for the screen.
 *
 * Example Usage:
 * ```
 * // Create an instance of HomeScreen representing the home screen with the route "home".
 * val homeScreen = Screen.HomeScreen
 * ```
 */
sealed class Screen(val route: String) {
    /**
     * Represents the home screen of the application.
     */
    object HomeScreen : Screen(route = "home")

}