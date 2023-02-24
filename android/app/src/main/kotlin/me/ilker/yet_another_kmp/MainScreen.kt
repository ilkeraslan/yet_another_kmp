package me.ilker.yet_another_kmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
internal fun MainScreen() {
    val navController = rememberNavController()

//    val bottomBar: @Composable () -> Unit = {
//        AppBottomNavigation(
//            navController = navController,
//            items = bottomNavItems
//        )
//    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
//        bottomBar = bottomBar
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.HomeScreen.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            HomeScreenFactory().create(
                navGraphBuilder = this,
                navController = navController
            )
        }
    }
}