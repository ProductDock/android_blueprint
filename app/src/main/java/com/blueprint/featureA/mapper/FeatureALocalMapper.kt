package com.blueprint.featureA.mapper

import com.blueprint.featureA.data.local_model.LocalFeatureA
import com.blueprint.featureA.domain.model.FeatureA

interface FeatureALocalMapper {

    fun map(featuresA: List<LocalFeatureA>): List<FeatureA>
    fun map(featureA: LocalFeatureA): FeatureA
}