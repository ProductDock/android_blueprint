package com.blueprint.featureA.data_sources.local

import javax.inject.Inject

class FeatureALocalDataSource @Inject constructor(
    private val featureADao: FeatureADao,
) {
}