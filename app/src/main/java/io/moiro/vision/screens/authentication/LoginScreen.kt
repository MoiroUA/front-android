package io.moiro.vision.screens.authentication

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.moiro.vision.screens.destinations.ProfileScreenDestination
import io.moiro.vision.screens.destinations.RegistrationScreenDestination
import io.moiro.vision.shared.models.Login
import io.moiro.vision.shared.models.LoginResponse
import io.moiro.vision.shared.services.client.ApiClient
import io.moiro.vision.shared.managers.SessionManager
import retrofit2.Call
import retrofit2.Response

@Destination
@Composable
fun LoginScreen(navigator: DestinationsNavigator) {
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val passwordVisible by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    SideEffect {
        systemUiController.setStatusBarColor(
            color = if (darkTheme) Color(0xFF1A7474) else Color(0xFFC9ECEC)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Вхід",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 52.dp),
            color = MaterialTheme.colors.primary
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text(text = "Електронна пошта") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onBackground,
                placeholderColor = MaterialTheme.colors.secondary,
                backgroundColor = MaterialTheme.colors.onPrimary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.secondary
            ),
            modifier = Modifier
                .size(width = 297.dp, height = 80.dp)
                .padding(bottom = 26.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = "Введіть пароль") },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onBackground,
                placeholderColor = MaterialTheme.colors.secondary,
                backgroundColor = MaterialTheme.colors.onPrimary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.secondary
            ),
            modifier = Modifier
                .size(width = 297.dp, height = 80.dp)
                .padding(bottom = 26.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp)
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .width(297.dp)
                .padding(bottom = 90.dp)
        ) {
            Text(
                text = "Забули пароль?",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    Toast.makeText(
                        context,
                        "Очікуйте наступних оновлень)",
                        Toast.LENGTH_LONG
                    ).show()
                })
        }
        Button(
            onClick = {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    val login = Login(email = email, password = password)
                    ApiClient().getApiService().loginUser(login)
                        .enqueue(object : retrofit2.Callback<LoginResponse> {
                            override fun onResponse(
                                call: Call<LoginResponse>,
                                response: Response<LoginResponse>
                            ) {
                                if (response.isSuccessful) {
                                    SessionManager(context).saveAuthToken(response.body()?.authToken.toString())
                                    navigator.navigate(ProfileScreenDestination())
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Пошта або пароль є неправильними",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }

                            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                                Toast.makeText(context, t.message.toString(), Toast.LENGTH_LONG)
                                    .show()
                            }
                        })
                }
            },
            modifier = Modifier
                .size(width = 297.dp, height = 59.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(
                text = "Увійти",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier.offset(y = (160).dp)
        ) {
            Text(
                text = "Не маєте облікового запису? ",
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "Зареєструватися",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    navigator.navigate(RegistrationScreenDestination())
                })
        }
    }
}
