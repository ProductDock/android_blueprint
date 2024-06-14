package com.blueprint.featureA.mapper

import com.blueprint.featureA.data.model.remote.NetworkFeatureA
import com.blueprint.featureA.domain.model.FeatureA

class DefaultFeatureARemoteMapper : FeatureARemoteMapper {
    override fun map(input: List<NetworkFeatureA>): List<FeatureA> =
        input.map { map(it) }

    override fun map(input: NetworkFeatureA): FeatureA =
        FeatureA(input.string)
}