package com.karunesh.exxceliqsolutiionsassignment.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import coil.compose.rememberImagePainter
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Data
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserProfileTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun userProfileLayoutTest() {
        composeTestRule.setContent {
            UserProfile(
                data = Data(
                    avatar = "avatar_url",
                    email = "example@example.com",
                    first_name = "John",
                    id = 1,
                    last_name = "Doe",
                    page = 1
                )
            )
        }

        // Verify that the profile picture is displayed
        composeTestRule.onNodeWithTag("profile_picture").assertIsDisplayed()

        // Verify that the user's first name is displayed
        composeTestRule.onNodeWithTag("first_name").assertIsDisplayed()

        // Verify that the user's last name is displayed
        composeTestRule.onNodeWithTag("last_name").assertIsDisplayed()

        // Verify that the user's email is displayed
        composeTestRule.onNodeWithTag("email").assertIsDisplayed()
    }
}

@Composable
fun UserProfile(data: Data) {
    Surface(modifier = Modifier.padding(16.dp)) {
        Row {
            // Profile Picture
            Image(
                painter = rememberImagePainter(data.avatar),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .testTag("profile_picture"),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Details Column
            Column {
                // First Name
                Text(
                    text = data.first_name,
                    modifier = Modifier.testTag("first_name")
                )

                // Last Name
                Text(
                    text = data.last_name,
                    modifier = Modifier.testTag("last_name")
                )

                // Email
                Text(
                    text = data.email,
                    modifier = Modifier.testTag("email")
                )
            }
        }
    }
}
