package com.blueprint.featureB.mapper

import com.blueprint.featureA.data.model.local.FeatureAEntity
import com.blueprint.featureA.domain.model.FeatureA
import com.blueprint.featureB.data.model.local.FeatureBEntity
import com.blueprint.featureB.domain.model.FeatureB

class DefaultFeatureBLocalMapper: FeatureBLocalMapper {
    override fun map(featuresB: List<FeatureBEntity>): List<FeatureB> =
        featuresB.map { map(it) }

    override fun map(featureB: FeatureBEntity): FeatureB =
        FeatureB(featureB.feature)
}