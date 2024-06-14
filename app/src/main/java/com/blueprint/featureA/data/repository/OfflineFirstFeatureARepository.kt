package com.blueprint.featureA.data.repository

import com.blueprint.di.DefaultDispatcher
import com.blueprint.featureA.data.sources.local.FeatureALocalDataSource
import com.blueprint.featureA.data.sources.remote.FeatureARemoteDataSource
import com.blueprint.featureA.domain.FeatureARepository
import com.blueprint.featureA.domain.model.FeatureA
import com.blueprint.featureA.mapper.DefaultFeatureALocalMapper
import com.blueprint.featureA.mapper.DefaultFeatureARemoteMapper
import com.blueprint.featureA.mapper.FeatureALocalMapper
import com.blueprint.featureA.mapper.FeatureARemoteMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstFeatureARepository @Inject constructor(
    private val localDataSource: FeatureALocalDataSource,
    private val remoteADataSource: FeatureARemoteDataSource,
    private val mapper: FeatureALocalMapper = DefaultFeatureALocalMapper(),
    private val remoteMapper: FeatureARemoteMapper = DefaultFeatureARemoteMapper(),
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher, // inject dispatchers
) : FeatureARepository {
    /**
     * Ultimately, this method would emit local values AND trigger a network update
     * The source-of-truth is the local state;
     * If network request is successful, it updates the database.
     */
    override fun getFeaturesA(): Flow<Result<List<FeatureA>>> =
        localDataSource.getFeaturesA().map {
            Result.success(mapper.map(it))
        }
}