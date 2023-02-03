package me.ilker.yet_another_kmp.shared.screen

import me.ilker.yet_another_kmp.models.Route
import me.ilker.yet_another_kmp.models.Screen
import me.ilker.yet_another_kmp.shared.route.RootRoute

data class RootScreen(
    override val route: Route = RootRoute,
    override val label: String = "Root"
) : Screen
