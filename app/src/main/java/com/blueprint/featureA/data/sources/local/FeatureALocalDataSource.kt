package com.blueprint.featureA.data.sources.local

import com.blueprint.featureA.data.model.local.FeatureAEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FeatureALocalDataSource @Inject constructor(
    private val featureADao: FeatureADao,
) {
    fun getFeaturesA(): Flow<List<FeatureAEntity>> = featureADao.getFeaturesA()
}