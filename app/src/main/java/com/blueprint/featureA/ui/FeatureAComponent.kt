package com.blueprint.featureA.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.blueprint.featureA.domain.model.FeatureA

@Composable
fun FeatureAScreen(viewModel: FeatureAViewModel) {
    Scaffold { innerPadding ->
        viewModel.getFeaturesA()
        val features = viewModel.features.collectAsStateWithLifecycle()
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
            SpaceList(features = features.value) { }
        }
    }
}

@Composable
fun SpaceList(features: List<FeatureA>, onCLick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(features) { _, item ->
                Item(featureA = item, onCLick)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Item(featureA: FeatureA, onCLick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        onClick = onCLick
    ) {
        Text(
            text = featureA.string,
            style = TextStyle(fontSize = 18.sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
        )
    }
}