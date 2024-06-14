package com.blueprint.featureA.domain

import com.blueprint.featureA.domain.model.FeatureA
import kotlinx.coroutines.flow.Flow

interface FeatureARepository {
    fun getFeaturesA() : Flow<Result<List<FeatureA>>>
}