package com.blueprint.featureA.mapper

import com.blueprint.featureA.data.local_model.LocalFeatureA
import com.blueprint.featureA.domain.FeatureA

class DefaultFeatureALocalMapper: FeatureALocalMapper {
    override fun map(featuresA: List<LocalFeatureA>): List<FeatureA> =
        featuresA.map { map(it) }

    override fun map(featureA: LocalFeatureA): FeatureA =
        FeatureA(featureA.string)
}