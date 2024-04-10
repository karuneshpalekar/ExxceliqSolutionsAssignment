package com.karunesh.exxceliqsolutiionsassignment.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.tooling.preview.Preview
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Data
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testHomeScreenLayout() {
        val userList = listOf(
            Data(
                avatar = "avatar1",
                email = "user1@example.com",
                first_name = "John",
                id = 1,
                last_name = "Koe",
                page = 1
            ),
            Data(
                avatar = "avatar2",
                email = "user2@example.com",
                first_name = "Jane",
                id = 2,
                last_name = "Smith",
                page = 2
            ),
            // Add more dummy data as needed
        )

        composeTestRule.setContent {
            HomeScreen(userList = userList)
        }

        // Verify that the first user's information is displayed
        composeTestRule.onNodeWithText("John").assertExists()

        // Verify that the second user's information is displayed
        composeTestRule.onNodeWithText("Jane").assertExists()

        // Verify that the retry button is displayed
        composeTestRule.onNodeWithText("Retry").assertExists()
    }
}

@Composable
fun HomeScreen(userList: List<Data>, onRetryClicked: () -> Unit = {}) {
    LazyColumn {
        items(userList.size) { user ->
            UserProfile(data = userList[user])
        }
    }
    Button(onClick = onRetryClicked) {
        Text(text = "Retry")
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    val userList = remember {
        listOf(
            Data(
                avatar = "avatar1",
                email = "user1@example.com",
                first_name = "John",
                id = 1,
                last_name = "Doe",
                page = 1
            ),
            Data(
                avatar = "avatar2",
                email = "user2@example.com",
                first_name = "Jane",
                id = 2,
                last_name = "Smith",
                page = 2
            )
        )
    }
    HomeScreen(userList = userList)
}
