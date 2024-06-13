package com.blueprint.featureA.data.repository

import com.blueprint.featureA.data.sources.local.FeatureALocalDataSource
import com.blueprint.featureA.data.sources.remote.FeatureARemoteDataSource
import com.blueprint.featureA.domain.FeatureARepository
import com.blueprint.featureA.domain.model.FeatureA
import javax.inject.Inject

class OfflineFirstFeatureARepository @Inject constructor(
    private val remoteADataSource: FeatureARemoteDataSource,
    private val localDataSource: FeatureALocalDataSource,
) : FeatureARepository {
    override suspend fun getFeaturesA(): Result<List<FeatureA>> {
        val resultList = listOf(
            FeatureA(
            "Test Feature 1"
            ),
            FeatureA(
                "Test Feature 2"
            ),
            )
        return Result.success(resultList)
    }
}