package io.moiro.vision.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.moiro.vision.screens.authentication.LoginScreen
import io.moiro.vision.screens.authentication.RegistrationScreen
import io.moiro.vision.screens.map.MapScreen

@Composable
fun AuthNav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreensRoutes.RegistrationScreen.route
    ) {
        composable(route = ScreensRoutes.RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }
        composable(route = ScreensRoutes.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = ScreensRoutes.MapScreen.route) {
            MapScreen()
        }
    }
}