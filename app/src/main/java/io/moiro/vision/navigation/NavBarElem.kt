package io.moiro.vision.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarElem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)
