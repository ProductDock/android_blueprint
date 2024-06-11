package com.blueprint.featureA.data.sources.local

import javax.inject.Inject

class FeatureALocalDataSource @Inject constructor(
    private val featureADao: FeatureADao,
) {
}