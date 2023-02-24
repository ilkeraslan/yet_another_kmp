package me.ilker.yet_another_kmp

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

class HomeScreenFactory : NavFactory {
    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.HomeScreen.route) {

        }
    }
}
