package com.karunesh.exxceliqsolutiionsassignment.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.karunesh.exxceliqsolutiionsassignment.presentation.HomeScreen
import com.karunesh.exxceliqsolutiionsassignment.presentation.HomeViewModel
import com.karunesh.exxceliqsolutiionsassignment.ui.theme.ExxceliqSolutiionsAssignmentTheme
import com.karunesh.exxceliqsolutiionsassignment.util.Screen
import dagger.hilt.android.AndroidEntryPoint

/**
 * The MainActivity class serves as the main entry point for the application. It hosts the navigation
 * functionality and sets up the initial screen to display.
 *
 * Example Usage:
 * ```
 * class MainActivity : ComponentActivity() {
 *     override fun onCreate(savedInstanceState: Bundle?) {
 *         super.onCreate(savedInstanceState)
 *         setContent {
 *             // Set up the navigation and initial screen
 *         }
 *     }
 * }
 * ```
 *
 * @see androidx.activity.ComponentActivity
 * @see androidx.compose.runtime.setContent
 * @see androidx.compose.material.Surface
 * @see androidx.compose.material.MaterialTheme
 * @see androidx.navigation.compose.NavHost
 * @see androidx.navigation.compose.composable
 * @see androidx.hilt.navigation.compose.hiltViewModel
 * @see com.google.accompanist.navigation.animation.rememberNavController
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Remember the navigation controller for managing navigation within the app
            val navController = rememberNavController()
            ExxceliqSolutiionsAssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Set up navigation using NavHost with the initial screen as HomeScreen
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        // Define composable for HomeScreen route
                        composable(route = Screen.HomeScreen.route) {
                            // Retrieve the HomeViewModel instance using hiltViewModel
                            val homeViewModel = hiltViewModel<HomeViewModel>()
                            // Display the HomeScreen composable with the retrieved view model
                            HomeScreen(
                                viewModel = homeViewModel,
                            )
                        }
                    }
                }
            }
        }
    }
}
