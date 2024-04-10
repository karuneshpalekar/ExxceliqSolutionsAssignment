package com.karunesh.exxceliqsolutiionsassignment.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Data

/**
 * The UserProfile composable function displays the profile details of a user.
 * It renders the user's profile picture, first name, last name, and email in a Surface container.
 *
 * @param data The data object representing the user's profile information.
 *
 * Example Usage:
 * ```
 * UserProfile(data = userData)
 * ```
 *
 * @see androidx.compose.runtime.Composable
 * @see androidx.compose.foundation.layout.Row
 * @see androidx.compose.foundation.layout.Column
 * @see androidx.compose.foundation.layout.Spacer
 * @see androidx.compose.foundation.layout.size
 * @see androidx.compose.foundation.layout.width
 * @see androidx.compose.material.Surface
 * @see androidx.compose.material.Text
 * @see androidx.compose.ui.Modifier
 * @see androidx.compose.ui.graphics.ContentScale
 * @see androidx.compose.ui.unit.dp
 * @see dev.chrisbanes.accompanist.coil.rememberCoilPainter
 */
@Composable
fun UserProfile(
    data: Data
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile Picture
            Image(
                painter = rememberAsyncImagePainter(data.avatar),
                contentDescription = null, // Set content description appropriately
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )

            // Spacing
            Spacer(modifier = Modifier.width(16.dp))

            // Details Column
            Column {
                // First Name
                Text(
                    text = data.first_name,
                    style = MaterialTheme.typography.subtitle1
                )

                // Last Name
                Text(
                    text = data.last_name,
                    style = MaterialTheme.typography.subtitle1
                )

                // Email
                Text(
                    text = data.email,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}


