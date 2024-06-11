package com.blueprint.featureA.repository

import com.blueprint.featureA.data.model.local.FeatureAEntity

interface FeatureALocalRepository {
    suspend fun insertFeatureA(featureAEntity: FeatureAEntity)
    suspend fun updateFeatureA(featureAEntity: FeatureAEntity)
    suspend fun getFeatureAById(id: Int): FeatureAEntity?
    suspend fun deleteFeatureAById(id: Int)
}