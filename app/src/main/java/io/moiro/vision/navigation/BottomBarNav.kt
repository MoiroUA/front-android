package io.moiro.vision.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.moiro.vision.screens.laws.LawsScreen
import io.moiro.vision.screens.map.MapScreen
import io.moiro.vision.screens.news.NewsScreen
import io.moiro.vision.screens.profile.ProfileScreen
import io.moiro.vision.screens.settings.SettingsScreen

@Composable
fun BottomBarNav(navHostController: NavHostController) {
    val navController = rememberNavController()
    NavHost(navController = navHostController, startDestination = ScreensRoutes.MapScreen.route) {
        composable(route = ScreensRoutes.MapScreen.route) {
            MapScreen(navController = navController)
        }
        composable(route = ScreensRoutes.NewsScreen.route) {
            NewsScreen(navController = navController)
        }
        composable(route = ScreensRoutes.LawsScreen.route) {
            LawsScreen(navController = navController)
        }
        composable(route = ScreensRoutes.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = ScreensRoutes.SettingsScreen.route) {
            SettingsScreen(navController = navController)
        }
    }
}