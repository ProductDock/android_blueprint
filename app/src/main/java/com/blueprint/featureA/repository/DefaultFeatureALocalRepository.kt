package com.blueprint.featureA.repository

import com.blueprint.featureA.data.local_model.LocalFeatureA
import com.blueprint.featureA.service.FeatureALocalService
import javax.inject.Inject

class DefaultFeatureALocalRepository @Inject constructor(
    private val featureALocalService: FeatureALocalService
) : FeatureALocalRepository{
    override suspend fun insertFeatureA(localFeatureA: LocalFeatureA) {
        featureALocalService.insertFeatureA(localFeatureA)
    }

    override suspend fun updateFeatureA(localFeatureA: LocalFeatureA) {
        featureALocalService.updateFeatureA(localFeatureA)
    }

    override suspend fun getFeatureAById(id: Int): LocalFeatureA? {
        return featureALocalService.getFeatureAById(id)
    }

    override suspend fun deleteFeatureAById(id: Int) {
        featureALocalService.deleteFeatureAById(id)
    }
}