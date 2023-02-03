package me.ilker.yet_another_kmp

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavFactory {
    fun create(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController
    )
}
