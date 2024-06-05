package com.blueprint.featureA.service

import com.blueprint.featureA.data.remote_model.RemoteFeatureA
import retrofit2.http.GET

interface FeatureAService {

    @GET("featureA")
    suspend fun fetchFeatureA(): Result<List<RemoteFeatureA>>
}