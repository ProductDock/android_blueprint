package com.blueprint.featureA.mapper

import com.blueprint.featureA.data.model.local.FeatureAEntity
import com.blueprint.featureA.domain.model.FeatureA

interface FeatureALocalMapper {

    fun map(featuresA: List<FeatureAEntity>): List<FeatureA>
    fun map(featureA: FeatureAEntity): FeatureA
}