package com.blueprint.featureA.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blueprint.featureA.domain.FeatureA
import com.blueprint.featureA.repository.FeatureARemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeatureAViewModel @Inject constructor(
    private val featureARemoteRepository: FeatureARemoteRepository
) : ViewModel() {

    private val _features = MutableStateFlow(emptyList<FeatureA>())
    val features = _features.asStateFlow()


    fun getFeaturesA() {
        viewModelScope.launch {
            _features.value = featureARemoteRepository.getFeaturesA().getOrElse { emptyList() }
        }
    }

}