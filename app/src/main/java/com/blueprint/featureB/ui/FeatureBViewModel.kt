package com.blueprint.featureB.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blueprint.featureA.domain.model.FeatureA
import com.blueprint.featureA.ui.FeatureAUiState
import com.blueprint.featureB.domain.FeatureBRepository
import com.blueprint.featureB.domain.model.FeatureB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeatureBViewModel @Inject constructor(
    private val featureBRepository: FeatureBRepository,
) : ViewModel() {

//    val featureBList = listOf(FeatureB("Prvi"), FeatureB("Drugi"), FeatureB("Treci"))
//
//    private val _features = MutableStateFlow(featureBList)

    val featureBList = listOf(FeatureB("Prvi"), FeatureB("Drugi"), FeatureB("Treci"))

    private val _featuresB = MutableStateFlow(featureBList)
    val featuresB = _featuresB.asStateFlow()

    val observableBFeatures: StateFlow<FeatureBUiState> = featureBRepository.getFeaturesB().map { result ->
        result.fold(
            onSuccess = { FeatureBUiState.Success(featureBList) },
            onFailure = { FeatureBUiState.Error(it.message.toString()) },
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = FeatureBUiState.Loading,
    )


    fun getFeaturesB() {
        viewModelScope.launch {
            featureBRepository.getFeaturesB().map { result ->
                _featuresB.value = result.fold(
                    onSuccess = { it },
                    onFailure = { emptyList() },
                )
            }
        }
    }

}

sealed class FeatureBUiState {
    data object Loading : FeatureBUiState()
    data class Success(val features: List<FeatureB>) : FeatureBUiState()
    data class Error(val message: String) : FeatureBUiState()
}