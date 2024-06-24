package com.blueprint.featureA.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blueprint.featureA.domain.FeatureARepository
import com.blueprint.featureA.domain.model.FeatureA
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
class FeatureAViewModel @Inject constructor(
    private val featureARepository: FeatureARepository,
) : ViewModel() {

    val featureList = listOf(FeatureA("2"), FeatureA("456"), FeatureA("222"), FeatureA("1906"))

    private val _features = MutableStateFlow(featureList)
//    private val _features = MutableStateFlow(emptyList<FeatureA>())
    val features = _features.asStateFlow()

    // TODO Do this, but reactively (observable way). Consider using distinctUntilChanged operator to avoid unnecessary UI updates
    val observableFeatures: StateFlow<FeatureAUiState> = featureARepository.getFeaturesA().map { result ->
        result.fold(
            onSuccess = { FeatureAUiState.Success(featureList) },
            onFailure = { FeatureAUiState.Error(it.message.toString()) },
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = FeatureAUiState.Loading,
    )

    // TODO Don't trigger explicitly from UI
    fun getFeaturesA() {
        viewModelScope.launch {
            featureARepository.getFeaturesA().map { result ->
                _features.value = result.fold(
                    onSuccess = { it },
                    onFailure = { emptyList() },
                )
            }
        }
    }
}

sealed class FeatureAUiState {
    data object Loading : FeatureAUiState()
    data class Success(val features: List<FeatureA>) : FeatureAUiState()
    data class Error(val message: String) : FeatureAUiState()
}