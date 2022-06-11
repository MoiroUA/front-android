package io.moiro.vision.screens.profile

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.moiro.vision.shared.managers.SessionManager
import io.moiro.vision.shared.models.User
import io.moiro.vision.shared.services.client.ApiClient
import retrofit2.Call
import retrofit2.Response

class ProfileViewModel : ViewModel() {
    var name by mutableStateOf("")
    var surname by mutableStateOf("")
    var phone by mutableStateOf("")
    var email by mutableStateOf("")
    var isSubscribed by mutableStateOf(false)

    fun getUserInfo(context: Context) {
        ApiClient().getApiService().getUser(SessionManager(context).fetchAuthToken().toString()).enqueue(
            object : retrofit2.Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        name = response.body()?.name.toString()
                        surname = response.body()?.surname.toString()
                        phone = response.body()?.phone.toString()
                        email = response.body()?.email.toString()
                        isSubscribed = response.body()?.isSub == true
                    } else {
                        Toast.makeText(context, "Щось пішло не так", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                }

            }
        )
    }
}