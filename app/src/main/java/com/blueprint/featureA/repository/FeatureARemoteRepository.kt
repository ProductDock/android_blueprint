package com.blueprint.featureA.repository

import com.blueprint.featureA.domain.model.FeatureA

interface FeatureARemoteRepository {

    suspend fun getFeaturesA(): Result<List<FeatureA>>

    suspend fun getLocalFeaturesA(): List<FeatureA>
}
