package com.blueprint.featureA.mapper

import com.blueprint.featureA.data.remote_model.RemoteFeatureA
import com.blueprint.featureA.domain.FeatureA

class DefaultFeatureARemoteRemoteMapper : FeatureARemoteMapper {
    override fun map(featuresA: List<RemoteFeatureA>): List<FeatureA> =
        featuresA.map { map(it) }

    override fun map(featureA: RemoteFeatureA): FeatureA =
        FeatureA(featureA.string)
}