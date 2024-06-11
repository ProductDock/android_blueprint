package com.blueprint.featureA.mapper

import com.blueprint.featureA.data.model.remote.NetworkFeatureA
import com.blueprint.featureA.domain.model.FeatureA

//interface Mapper<I, O> {
//    fun map(input: I): O
//    fun map(input: List<I>): List<O>
//}

interface FeatureARemoteMapper {
    fun map(input: List<NetworkFeatureA>): List<FeatureA>
    fun map(input: NetworkFeatureA): FeatureA

}