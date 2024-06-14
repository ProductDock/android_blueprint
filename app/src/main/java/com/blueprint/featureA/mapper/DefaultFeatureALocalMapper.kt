package com.blueprint.featureA.mapper

import com.blueprint.featureA.data.model.local.FeatureAEntity
import com.blueprint.featureA.domain.model.FeatureA

class DefaultFeatureALocalMapper: FeatureALocalMapper {
    override fun map(featuresA: List<FeatureAEntity>): List<FeatureA> =
        featuresA.map { map(it) }

    override fun map(featureA: FeatureAEntity): FeatureA =
        FeatureA(featureA.string)
}