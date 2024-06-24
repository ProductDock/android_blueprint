package com.blueprint.featureB.data.repository

import com.blueprint.di.DefaultDispatcher
import com.blueprint.featureA.data.sources.local.FeatureALocalDataSource
import com.blueprint.featureA.data.sources.remote.FeatureARemoteDataSource
import com.blueprint.featureA.domain.FeatureARepository
import com.blueprint.featureA.domain.model.FeatureA
import com.blueprint.featureA.mapper.DefaultFeatureALocalMapper
import com.blueprint.featureA.mapper.DefaultFeatureARemoteMapper
import com.blueprint.featureA.mapper.FeatureALocalMapper
import com.blueprint.featureA.mapper.FeatureARemoteMapper
import com.blueprint.featureB.data.sources.local.FeatureBLocalDataSource
import com.blueprint.featureB.domain.FeatureBRepository
import com.blueprint.featureB.domain.model.FeatureB
import com.blueprint.featureB.mapper.DefaultFeatureBLocalMapper
import com.blueprint.featureB.mapper.FeatureBLocalMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstFeatureBRepository @Inject constructor(
    private val localDataSource: FeatureBLocalDataSource,
//    private val remoteADataSource: FeatureBRemoteDataSource,
    private val mapper: FeatureBLocalMapper = DefaultFeatureBLocalMapper(),
//    private val remoteMapper: FeatureBRemoteMapper = DefaultFeatureBRemoteMapper(),
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher, // inject dispatchers
) : FeatureBRepository {
    /**
     * Ultimately, this method would emit local values AND trigger a network update
     * The source-of-truth is the local state;
     * If network request is successful, it updates the database.
     */
    override fun getFeaturesB(): Flow<Result<List<FeatureB>>> =
        localDataSource.getFeaturesB().map {
            Result.success(mapper.map(it))
        }
}