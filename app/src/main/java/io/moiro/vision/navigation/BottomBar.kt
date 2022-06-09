package io.moiro.vision.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun BottomBar(
    screens: List<NavBarElem>,
    onItemClick: (NavBarElem) -> Unit
) {
    BottomNavigation(backgroundColor = MaterialTheme.colors.onPrimary) {
        screens.forEach { screen ->
            BottomNavigationItem(
                selected = false, onClick = { onItemClick(screen) },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (screen.badgeCount > 0) {
                            BadgedBox(badge = {
                                Text(text = screen.badgeCount.toString())
                            }) {
                                Icon(imageVector = screen.icon, contentDescription = screen.name)
                                Text(
                                    text = screen.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        } else {
                            Icon(imageVector = screen.icon, contentDescription = screen.name)
                            Text(
                                text = screen.name, textAlign = TextAlign.Center, fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }, unselectedContentColor = MaterialTheme.colors.primary
            )
        }
    }
}