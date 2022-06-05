package io.moiro.vision.shared.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("first_name")
    val name: String,
    @SerializedName("last_name")
    val surname: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone_number")
    val phone: String,
    @SerializedName("is_subscribed")
    val isSub: Boolean
)
