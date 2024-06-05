package com.blueprint.featureA.repository

import com.blueprint.featureA.data.local_model.LocalFeatureA

interface FeatureALocalRepository {
    suspend fun insertFeatureA(localFeatureA: LocalFeatureA)
    suspend fun updateFeatureA(localFeatureA: LocalFeatureA)
    suspend fun getFeatureAById(id: Int): LocalFeatureA?
    suspend fun deleteFeatureAById(id: Int)
}