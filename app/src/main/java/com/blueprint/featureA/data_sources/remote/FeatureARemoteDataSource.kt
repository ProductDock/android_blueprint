package com.blueprint.featureA.data_sources.remote

import javax.inject.Inject

class FeatureARemoteDataSource @Inject constructor(
    private val featureAService: FeatureAService
) {
}