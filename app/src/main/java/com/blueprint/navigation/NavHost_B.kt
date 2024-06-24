package com.blueprint.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.blueprint.featureB.graph.screenBNavGraph
import com.blueprint.featureB.screens.ScreenB

@Composable
fun NavHost_B() {
    val navBController = rememberNavController()

    NavHost(
        navController = navBController,
        startDestination = ScreenB.ScreenB1
    ) {
        screenBNavGraph(navBController)
    }
}