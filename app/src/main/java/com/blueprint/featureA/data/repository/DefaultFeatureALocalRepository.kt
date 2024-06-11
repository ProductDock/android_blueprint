package com.blueprint.featureA.data.repository

import com.blueprint.featureA.data.model.local.FeatureAEntity
import com.blueprint.featureA.data.sources.local.FeatureADao
import javax.inject.Inject

class DefaultFeatureALocalRepository @Inject constructor(
    private val featureADao: FeatureADao
) : FeatureALocalRepository {
    override suspend fun insertFeatureA(featureAEntity: FeatureAEntity) {
        featureADao.insertFeatureA(featureAEntity)
    }

    override suspend fun updateFeatureA(featureAEntity: FeatureAEntity) {
        featureADao.updateFeatureA(featureAEntity)
    }

    override suspend fun getFeatureAById(id: Int): FeatureAEntity? {
        return featureADao.getFeatureAById(id)
    }

    override suspend fun deleteFeatureAById(id: Int) {
        featureADao.deleteFeatureAById(id)
    }
}