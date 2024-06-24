package com.blueprint.featureA.ui

import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.blueprint.R
import com.blueprint.featureA.domain.model.FeatureA
import com.blueprint.featureB.screens.ScreenB
import com.blueprint.navigation.ScreenB_Graph
import kotlin.random.Random

@Composable
fun FeatureAScreen(navController: NavController, viewModel: FeatureAViewModel) {
    val features by viewModel.observableFeatures.collectAsStateWithLifecycle()
    viewModel.getFeaturesA()
    FeaturesAContent(features, navController)
}

@Composable
private fun FeaturesAContent(features: FeatureAUiState, navController: NavController) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                "Welcome",
                modifier = Modifier
                    .padding(30.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            FeatureAList(features = features, navController = navController)
        }
    }
}

@Composable
fun FeatureAList(features: FeatureAUiState, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {

        when (features) {
            is FeatureAUiState.Loading -> {
                Text(
                    text = "Loading...",
                    style = TextStyle(fontSize = 18.sp),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp),
                )
            }

            is FeatureAUiState.Error -> {
                Text(
                    text = "Error: ${features.message}",
                    style = TextStyle(fontSize = 18.sp),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp),
                )
            }

            is FeatureAUiState.Success -> {
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    itemsIndexed(features.features) { _, item ->
                        Item(featureA = item, navController = navController)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Item(featureA: FeatureA, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        onClick = {
//            navController.popBackStack()
            navController.navigate(ScreenB_Graph)
        }
    ) {
        Text(
            text = featureA.string,
            style = TextStyle(fontSize = 18.sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
        )
    }
}

//@Composable
//fun FeatureAScreen(
//    navController: NavController,
//    viewModel: FeatureAViewModel
//) {
//    Scaffold { innerPadding ->
//        viewModel.getFeaturesA()
//        val features = viewModel.features.collectAsStateWithLifecycle()
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//        ) {
//            Text(
//                "Welcome",
//                modifier = Modifier
//                    .padding(30.dp)
//            )
//            SpaceList(features = features.value, navController)
//        }
//    }
//}
//
//@Composable
//fun SpaceList(features: List<FeatureA>, navController: NavController) {
//    LazyColumn(
//        modifier = Modifier.fillMaxWidth(),
//        contentPadding = PaddingValues(16.dp)
//    ) {
//        item {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//                    .padding(vertical = 25.dp),
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(text = "hello losers!")
//            }
//        }
//        items(features) { feature ->
//            Item(featureA = feature, navController)
//        }
//    }
//}
//
//
//@Composable
//fun Item(featureA: FeatureA, navController: NavController) {
//    Card(
//        modifier = Modifier
//            .padding(16.dp)
//            .wrapContentWidth()
//            .wrapContentHeight(),
//        shape = RoundedCornerShape(8.dp),
//        onClick = {
//            navController.popBackStack()
//            navController.navigate(ScreenB_Graph)
//        }
//    ) {
//        Text(
//            text = featureA.string,
//            style = TextStyle(fontSize = 18.sp),
//            textAlign = TextAlign.Center,
//            modifier = Modifier.padding(16.dp),
//        )
//    }
//}