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
import io.moiro.vision.screens.destinations.LoginScreenDestination
import io.moiro.vision.shared.models.RegResponse
import io.moiro.vision.shared.models.Registration
import io.moiro.vision.shared.services.client.ApiClient
import retrofit2.Call
import retrofit2.Response

@Destination(start = true)
@Composable
fun RegistrationScreen(navigator: DestinationsNavigator) {
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
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
            text = "Реєстрація",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 52.dp),
            color = MaterialTheme.colors.primary
        )
        TextField(
            value = name,
            onValueChange = { name = it },
            placeholder = { Text(text = "Ім’я") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
            value = surname,
            onValueChange = { surname = it },
            placeholder = { Text(text = "Прізвище") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
        TextField(
            value = passwordConfirm,
            onValueChange = { passwordConfirm = it },
            placeholder = { Text(text = "Підтвердіть пароль") },
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
        Button(
            onClick = {
                if (name.isNotEmpty() && surname.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password == passwordConfirm) {
                    val reg = Registration(
                        name = name,
                        surname = surname,
                        email = email,
                        password = passwordConfirm
                    )
                    ApiClient().getApiService().regUser(reg)
                        .enqueue(object : retrofit2.Callback<RegResponse> {
                            override fun onResponse(
                                call: Call<RegResponse>,
                                response: Response<RegResponse>
                            ) {
                                if (response.isSuccessful) {
                                    navigator.navigate(LoginScreenDestination())
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Щось пішло не так",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }

                            override fun onFailure(call: Call<RegResponse>, t: Throwable) {
                                Toast.makeText(
                                    context,
                                    t.message.toString(),
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        })
                }
            },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .size(width = 297.dp, height = 59.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(30.dp))
        ) {
            Text(
                text = "Зареєструватись",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text(
                text = "Вже маєте обліковий запис? ",
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = "Увійти",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    navigator.navigate(LoginScreenDestination())
                })
        }
    }
}
