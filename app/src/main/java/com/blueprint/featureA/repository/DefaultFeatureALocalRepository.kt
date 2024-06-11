package com.blueprint.featureA.repository

import com.blueprint.featureA.data.local_model.LocalFeatureA
import com.blueprint.featureA.data_sources.local.FeatureADao
import javax.inject.Inject

class DefaultFeatureALocalRepository @Inject constructor(
    private val featureADao: FeatureADao
) : FeatureALocalRepository{
    override suspend fun insertFeatureA(localFeatureA: LocalFeatureA) {
        featureADao.insertFeatureA(featureAEntity)
    }

    override suspend fun updateFeatureA(localFeatureA: LocalFeatureA) {
        featureADao.updateFeatureA(featureAEntity)
    }

    override suspend fun getFeatureAById(id: Int): LocalFeatureA? {
        return featureADao.getFeatureAById(id)
    }

    override suspend fun deleteFeatureAById(id: Int) {
        featureADao.deleteFeatureAById(id)
    }
}