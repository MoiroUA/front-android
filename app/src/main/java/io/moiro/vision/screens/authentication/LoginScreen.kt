package io.moiro.vision.screens.authentication

import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import io.moiro.vision.navigation.ScreensRoutes
import io.moiro.vision.shared.managers.SessionManager
import io.moiro.vision.shared.models.Login
import io.moiro.vision.shared.models.LoginResponse
import io.moiro.vision.shared.services.client.ApiClient
import retrofit2.Call
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavController) {
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
            .background(MaterialTheme.colors.background)
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "????????",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.height(50.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text(text = "???????????????????? ??????????") },
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
                .size(width = 297.dp, height = 50.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp)
        )
        Spacer(modifier = Modifier.height(23.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = "?????????????? ????????????") },
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
                .size(width = 297.dp, height = 50.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp)
        )
        Spacer(modifier = Modifier.height(21.dp))
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .width(297.dp)
        ) {
            Text(
                text = "???????????? ?????????????",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    Toast.makeText(
                        context,
                        "???????????????? ?????????????????? ????????????????)",
                        Toast.LENGTH_LONG
                    ).show()
                })
        }
        Spacer(modifier = Modifier.height(100.dp))
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
                                    navController.navigate(ScreensRoutes.ProfileScreen.route)
                                } else {
                                    Toast.makeText(
                                        context,
                                        "?????????? ?????? ???????????? ?? ??????????????????????????",
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
                .size(width = 297.dp, height = 50.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(
                text = "????????????",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(199.dp))
        Row {
            Text(
                text = "???? ?????????? ???????????????????? ????????????? ",
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "??????????????????????????????",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    navController.navigate(ScreensRoutes.RegistrationScreen.route)
                })
        }
    }
}
