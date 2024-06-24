package com.blueprint.featureB.mapper

import com.blueprint.featureB.data.model.local.FeatureBEntity
import com.blueprint.featureB.domain.model.FeatureB


interface FeatureBLocalMapper {


    fun map(featuresB: List<FeatureBEntity>): List<FeatureB>

    fun map(featureB: FeatureBEntity): FeatureB
}