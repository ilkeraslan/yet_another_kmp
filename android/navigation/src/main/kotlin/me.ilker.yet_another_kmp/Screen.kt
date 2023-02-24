package me.ilker.yet_another_kmp

import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val label: String,
    val icon: ImageVector? = null
) {
    object HomeScreen : Screen(
        route = "home",
        label = "Home"
    )
}
