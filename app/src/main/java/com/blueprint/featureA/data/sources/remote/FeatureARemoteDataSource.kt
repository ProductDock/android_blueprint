package com.blueprint.featureA.data.sources.remote

import com.blueprint.featureA.data.model.remote.NetworkFeatureA
import javax.inject.Inject

class FeatureARemoteDataSource @Inject constructor(
    private val featureAService: FeatureAService
) {
    suspend fun getFeaturesA(): Result<List<NetworkFeatureA>> = featureAService.fetchFeaturesA()
}