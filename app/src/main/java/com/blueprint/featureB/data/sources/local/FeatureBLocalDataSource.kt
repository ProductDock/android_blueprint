package com.blueprint.featureB.data.sources.local

import com.blueprint.featureB.data.model.local.FeatureBEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FeatureBLocalDataSource @Inject constructor(
    private val featureBDao: FeatureBDao,
) {
    fun getFeaturesB(): Flow<List<FeatureBEntity>> = featureBDao.getFeaturesB()
}