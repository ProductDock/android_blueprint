package com.blueprint.featureA.data.sources.remote

import com.blueprint.featureA.data.model.remote.NetworkFeatureA
import retrofit2.http.GET

interface FeatureAService {

    @GET("featureA")
    suspend fun fetchFeatureA(): Result<List<NetworkFeatureA>>
}