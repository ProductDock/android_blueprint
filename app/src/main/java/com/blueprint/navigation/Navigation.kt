package com.blueprint.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.blueprint.featureA.screens.ScreenA
import com.blueprint.featureA.ui.FeatureAScreen
import com.blueprint.featureA.ui.FeatureAViewModel
import com.example.nestednavcompose.ui.view_model.sharedViewModel
import kotlinx.serialization.Serializable

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenA.ScreenA1
    ) {
        composable<ScreenA.ScreenA1> {
            val viewModel = it.sharedViewModel<FeatureAViewModel>(navController)
            FeatureAScreen(navController, viewModel)
        }
        composable<ScreenB_Graph> {
            NavHost_B()
        }
    }
}



// Graph list
@Serializable
object ScreenB_Graph