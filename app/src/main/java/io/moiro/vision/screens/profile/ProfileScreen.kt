package io.moiro.vision.screens.profile

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ProfileScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()
    val context = LocalContext.current

    SideEffect {
        systemUiController.setStatusBarColor(
            color = if (darkTheme) Color(0xFF1A7474) else Color(0xFFFFFFFF)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onPrimary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .width(305.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Обліковий запис",
                fontSize = 22.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colors.onBackground
            )
        }
        Spacer(modifier = Modifier.height(53.dp))
        Icon(
            modifier = Modifier
                .size(75.dp),
            imageVector = Icons.Filled.AccountCircle,
            tint = MaterialTheme.colors.primary,
            contentDescription = "user"
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Ігор Вілков",
            fontSize = 23.sp,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(55.dp))
        Column(modifier = Modifier.width(305.dp)) {
            Text(
                text = "Телефон",
                fontSize = 15.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "+380 98 404 69 01",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(43.dp))
            Text(
                text = "Електронна пошта",
                fontSize = 15.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "igorvilkov404@gmail.com",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(43.dp))
            Text(
                text = "Група крові (за бажанням)",
                fontSize = 15.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "O(I)+",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colors.primary
            )
        }
        Spacer(modifier = Modifier.height(36.dp))
        Row(
            modifier = Modifier
                .width(297.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Редагувати інформацію",
                fontSize = 12.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    Toast.makeText(context, "Очікуйте наступних оновлень)", Toast.LENGTH_LONG)
                        .show()
                }
            )
        }
        Spacer(modifier = Modifier.height(89.dp))
        Text(
            text = "Вийти з облікового запису",
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colors.error
        )
    }
}
