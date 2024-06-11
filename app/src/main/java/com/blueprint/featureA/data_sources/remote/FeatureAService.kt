package com.blueprint.featureA.data_sources.remote

import com.blueprint.featureA.data.remote_model.NetworkFeatureA
import retrofit2.http.GET

interface FeatureAService {

    @GET("featureA")
    suspend fun fetchFeatureA(): Result<List<NetworkFeatureA>>
}