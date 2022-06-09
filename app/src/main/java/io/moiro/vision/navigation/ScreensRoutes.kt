package io.moiro.vision.navigation

sealed class ScreensRoutes(val route: String) {
    object RegistrationScreen : ScreensRoutes("reg")
    object LoginScreen : ScreensRoutes("log")
    object MapScreen : ScreensRoutes("map")
    object LawsScreen : ScreensRoutes("laws")
    object NewsScreen : ScreensRoutes("news")
    object ProfileScreen : ScreensRoutes("profile")
    object SettingsScreen : ScreensRoutes("settings")
}
