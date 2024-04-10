package com.karunesh.exxceliqsolutiionsassignment.data.remote.dto

import android.os.Parcelable
import com.karunesh.exxceliqsolutiionsassignment.domain.model.Support
import kotlinx.parcelize.Parcelize

/**
 * The SupportDto data class represents a Support transfer object (DTO) containing support information fields.
 * It encapsulates properties such as text and URL.
 *
 * @property text The text describing the support information.
 * @property url The URL associated with the support information.
 *
 * Example Usage:
 * ```
 * val supportDto = SupportDto(
 *     text = "Contact us for support",
 *     url = "https://example.com/support"
 * )
 * ```
 *
 * @see kotlinx.parcelize.Parcelize
 * @see kotlinx.android.parcel.Parcelize
 */
@Parcelize
data class SupportDto(
    val text: String,
    val url: String
) : Parcelable {

    /**
     * Converts the SupportDto object to a Support object.
     *
     * @return A Support object representing the converted support information.
     */
    fun toSupport(): Support {
        return Support(
            text = text,
            url = url
        )
    }

}