package io.moiro.vision.screens.laws

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LawsScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = if (darkTheme) Color(0xFF1A7474) else Color(0xFFFFFFFF)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onPrimary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Очікуйте наступних оновлень)",
            fontSize = 22.sp,
            fontWeight = FontWeight.Light,
            color = MaterialTheme.colors.secondary
        )
    }
}