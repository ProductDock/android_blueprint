package com.blueprint.featureA.mapper

import com.blueprint.featureA.data.remote_model.RemoteFeatureA
import com.blueprint.featureA.domain.FeatureA

interface FeatureARemoteMapper {

    fun map(featuresA: List<RemoteFeatureA>): List<FeatureA>
    fun map(featureA: RemoteFeatureA): FeatureA

}