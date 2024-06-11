package com.blueprint.featureA.repository

import com.blueprint.featureA.data_sources.local.FeatureALocalDataSource
import com.blueprint.featureA.data_sources.remote.FeatureARemoteDataSource
import com.blueprint.featureA.domain.FeatureARepository
import com.blueprint.featureA.domain.model.FeatureA
import javax.inject.Inject

class OfflineFirstFeatureARepository @Inject constructor(
    private val remoteADataSource: FeatureARemoteDataSource,
    private val localDataSource: FeatureALocalDataSource,
) : FeatureARepository {
    override suspend fun getFeaturesA(): Result<List<FeatureA>> {
        TODO("Not yet implemented")
    }
}