package io.moiro.vision

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import io.moiro.vision.navigation.*
import io.moiro.vision.shared.managers.SessionManager
import io.moiro.vision.ui.theme.VisionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            val darkTheme = isSystemInDarkTheme()
            val context = LocalContext.current
            val isLog = SessionManager(context).fetchAuthToken() != null

            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = !darkTheme
                )
            }
            VisionTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (!isLog) {
                        AuthNav()
                    } else {
                        Scaffold(bottomBar = {
                            BottomBar(
                                screens = listOf(
                                    NavBarElem(
                                        name = "Карта",
                                        route = ScreensRoutes.MapScreen.route,
                                        icon = Icons.Default.Map
                                    ),
                                    NavBarElem(
                                        name = "Новини",
                                        route = ScreensRoutes.NewsScreen.route,
                                        icon = Icons.Default.Feed
                                    ),
                                    NavBarElem(
                                        name = "Закони",
                                        route = ScreensRoutes.LawsScreen.route,
                                        icon = Icons.Default.Gavel
                                    ),
                                    NavBarElem(
                                        name = "Профіль",
                                        route = ScreensRoutes.ProfileScreen.route,
                                        icon = Icons.Default.Person
                                    ),
                                    NavBarElem(
                                        name = "Налаштування",
                                        route = ScreensRoutes.SettingsScreen.route,
                                        icon = Icons.Default.Settings
                                    ),
                                ), onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        }) {
                            BottomBarNav(navHostController = navController)
                        }
                    }
                }
            }
        }
    }
}
