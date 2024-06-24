package com.blueprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.blueprint.featureA.ui.FeatureAScreen
import com.blueprint.featureA.ui.FeatureAViewModel
import com.blueprint.featureB.ui.FeatureBScreen
import com.blueprint.featureB.ui.FeatureBViewModel
import com.blueprint.navigation.Navigation
import com.blueprint.ui.theme.BlueprintTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlueprintTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Navigation()
//                        val viewModel by viewModels<FeatureAViewModel>()
//                        FeatureAScreen(viewModel = viewModel)
//                        val viewModel by viewModels<FeatureBViewModel>()
//                        FeatureBScreen(viewModel = viewModel)
                    }
                }
            }
        }
    }
}
