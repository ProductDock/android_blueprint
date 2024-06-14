package com.blueprint.featureA.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blueprint.featureA.domain.FeatureARepository
import com.blueprint.featureA.domain.model.FeatureA
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeatureAViewModel @Inject constructor(
    private val featureARepository: FeatureARepository,
) : ViewModel() {

    private val _features = MutableStateFlow(emptyList<FeatureA>())
    val features = _features.asStateFlow()

    // TODO Don't trigger explicitly from UI
    fun getFeaturesA() {
        viewModelScope.launch {
            featureARepository.getFeaturesA().map { result ->
                _features.value = result.fold(
                    onSuccess = { it } ,
                    onFailure = { emptyList() },
                )
            }
        }
    }
}