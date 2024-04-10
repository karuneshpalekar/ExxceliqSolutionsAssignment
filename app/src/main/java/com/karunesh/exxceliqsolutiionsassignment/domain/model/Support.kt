package com.karunesh.exxceliqsolutiionsassignment.domain.model

/**
 * The Support data class represents a support entity containing text and a URL.
 * It encapsulates properties such as text and URL to provide support information.
 *
 * @property text The text describing the support information.
 * @property url The URL associated with the support information.
 *
 * Example Usage:
 * ```
 * val supportInfo = Support(
 *     text = "Contact us for support",
 *     url = "https://example.com/support"
 * )
 * ```
 */
data class Support(
    val text: String,
    val url: String
)