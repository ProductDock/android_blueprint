package com.blueprint.featureB.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.blueprint.featureB.domain.model.FeatureB
import com.blueprint.featureB.screens.ScreenB

@Composable
fun FeatureBScreen(
    navController: NavController,
    viewModel: FeatureBViewModel
) {
    Scaffold { innerPadding ->
        val featuresB by viewModel.observableBFeatures.collectAsStateWithLifecycle()
        viewModel.getFeaturesB()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Welcome to FeatureB screen",
                modifier = Modifier
                    .padding(30.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            FeaturesB(featuresB = featuresB, navController = navController)
        }
    }
}

@Composable
fun FeaturesB(
    featuresB: FeatureBUiState,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        when (featuresB) {
            is FeatureBUiState.Loading -> {
                Text(
                    text = "Loading...",
                    style = TextStyle(fontSize = 18.sp),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp),
                )
            }

            is FeatureBUiState.Error -> {
                Text(
                    text = "Error: ${featuresB.message}",
                    style = TextStyle(fontSize = 18.sp),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp),
                )
            }

            is FeatureBUiState.Success -> {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    itemsIndexed(featuresB.features) { _, item ->
                        ItemB(featureB = item, navController = navController)
                    }
                }
            }
        }
    }
}


@Composable
fun ItemB(featureB: FeatureB, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        onClick = {
//            navController.popBackStack()
            navController.navigate(ScreenB.ScreenB1Details(
                id = 300
            ))
        }
    ) {
        Text(
            text = featureB.feature,
            style = TextStyle(fontSize = 18.sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
        )
    }
}
