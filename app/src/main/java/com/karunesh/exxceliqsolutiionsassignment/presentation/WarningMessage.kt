package com.karunesh.exxceliqsolutiionsassignment.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.karunesh.exxceliqsolutiionsassignment.R

/**
 * The WarningMessage composable function displays a warning message with optional trailing content.
 * It typically includes an icon indicating a warning, a text message, and optional additional content.
 *
 * @param text The text message to be displayed as the warning message.
 * @param trailingContent The optional composable function representing additional content to be displayed
 *                        after the text message. If not provided, no trailing content will be displayed.
 *
 * Example Usage:
 * ```
 * WarningMessage(
 *     text = "This is a warning message",
 *     trailingContent = {
 *         Text(text = "Learn more")
 *     }
 * )
 * ```
 *
 * @see androidx.compose.runtime.Composable
 * @see androidx.compose.foundation.layout.Column
 * @see androidx.compose.foundation.layout.Row
 * @see androidx.compose.foundation.layout.Spacer
 * @see androidx.compose.material.Icon
 * @see androidx.compose.material.Text
 * @see androidx.compose.ui.Modifier
 * @see androidx.compose.ui.graphics.painterResource
 * @see androidx.compose.ui.unit.dp
 */
@Composable
fun WarningMessage(
    text: String,
    trailingContent: (@Composable () -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(fraction = 0.90f)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Warning icon
        Icon(
            painter = painterResource(id = R.drawable.ic_circle_info_solid),
            tint = MaterialTheme.colors.onSurface,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        // Text message and optional trailing content
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.subtitle2
            )
            trailingContent?.invoke()
        }
    }

}