package com.blueprint.featureA.mapper

import com.blueprint.featureA.data.model.remote.NetworkFeatureA
import com.blueprint.featureA.domain.model.FeatureA

class DefaultFeatureARemoteRemoteMapper : FeatureARemoteMapper {
    override fun map(featuresA: List<NetworkFeatureA>): List<FeatureA> =
        featuresA.map { map(it) }

    override fun map(featureA: NetworkFeatureA): FeatureA =
        FeatureA(featureA.string)
}