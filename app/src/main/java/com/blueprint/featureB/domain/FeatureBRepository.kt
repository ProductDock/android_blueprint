package com.blueprint.featureB.domain
import com.blueprint.featureB.domain.model.FeatureB
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface FeatureBRepository {
    fun getFeaturesB() : Flow<Result<List<FeatureB>>>
}