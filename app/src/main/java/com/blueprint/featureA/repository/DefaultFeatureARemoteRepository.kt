package com.blueprint.featureA.repository

import com.blueprint.featureA.service.FeatureAService
import com.blueprint.featureA.domain.model.FeatureA
import com.blueprint.featureA.mapper.FeatureARemoteMapper
import javax.inject.Inject

class DefaultFeatureARemoteRepository @Inject constructor(
    private val featureARemoteMapper: FeatureARemoteMapper,
    private val featureAService: FeatureAService,
) : FeatureARemoteRepository {
    override suspend fun getFeaturesA(): Result<List<FeatureA>> =
        featureAService.fetchFeatureA().map { featureARemoteMapper.map(it) }

    override suspend fun getLocalFeaturesA(): List<FeatureA> {
        TODO("Not yet implemented")
    }
}