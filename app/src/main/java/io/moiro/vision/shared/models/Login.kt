package io.moiro.vision.shared.models

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("username")
    val email: String,
    @SerializedName("password")
    val password: String
)
