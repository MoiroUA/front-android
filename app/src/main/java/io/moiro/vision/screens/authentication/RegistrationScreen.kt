package io.moiro.vision.screens.authentication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.moiro.vision.screens.authentication.destinations.LoginScreenDestination

@Destination(start = true)
@Composable
fun RegistrationScreen(navigator: DestinationsNavigator) {
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = if (darkTheme) Color(0xFF1A7474) else Color(0xFFD9F9F3)
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
        TextField(value = "", onValueChange = {}, placeholder = { Text(text = "Ім’я") },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0x000EF355),
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
        TextField(value = "", onValueChange = {}, placeholder = { Text(text = "Прізвище") },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0x000EF355),
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
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Електронна пошта") },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0x000EF355),
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
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Введіть пароль") },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0x000EF355),
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
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Підтвердіть пароль") },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0x000EF355),
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
            onClick = { /*TODO*/ },
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
