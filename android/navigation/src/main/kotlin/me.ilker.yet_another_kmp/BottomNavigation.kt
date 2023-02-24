package me.ilker.yet_another_kmp

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationItem>
) {
    BottomNavigation(
        backgroundColor = Color(0XFFA30900),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.map { it.screen }.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    screen.icon?.let {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = screen.label
                        )
                    }
                },
                label = { Text(screen.label) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}