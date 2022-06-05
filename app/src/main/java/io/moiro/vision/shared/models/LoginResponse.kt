package io.moiro.vision.shared.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val authToken: String
)
