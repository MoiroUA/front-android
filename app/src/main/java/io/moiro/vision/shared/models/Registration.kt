package io.moiro.vision.shared.models

import com.google.gson.annotations.SerializedName

data class Registration(
    @SerializedName("first_name")
    val name: String,
    @SerializedName("last_name")
    val surname: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
