package com.blueprint.featureA.data.sources.remote

import javax.inject.Inject

class FeatureARemoteDataSource @Inject constructor(
    private val featureAService: FeatureAService
) {
}