package com.blueprint.featureA.domain

import com.blueprint.featureA.domain.model.FeatureA

interface FeatureARepository {

    suspend fun getFeaturesA() : List<FeatureA>
}