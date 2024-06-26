package com.blueprint.featureB.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.blueprint.featureB.screens.ScreenB
import com.blueprint.featureB.ui.FeatureB1Details
import com.blueprint.featureB.ui.FeatureBScreen
import com.blueprint.featureB.ui.FeatureBViewModel
import com.example.nestednavcompose.ui.view_model.sharedViewModel

fun NavGraphBuilder.screenBNavGraph(
    navController: NavHostController
) {
    composable<ScreenB.ScreenB1> {
        val viewModel = it.sharedViewModel<FeatureBViewModel>(navController)
        FeatureBScreen(navController = navController, viewModel)
    }
    composable<ScreenB.ScreenB1Details> {
        val args = it.toRoute<ScreenB.ScreenB1Details>()
        FeatureB1Details(args.id)
    }
}