package com.blueprint.featureA.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.blueprint.featureA.data.local_model.LocalFeatureA


@Dao
interface FeatureALocalService {
    @Insert
    suspend fun insertFeatureA(localFeatureA: LocalFeatureA)

    @Update
    suspend fun updateFeatureA(localFeatureA: LocalFeatureA)

    @Query("SELECT * FROM feature_a WHERE id = :id")
    suspend fun getFeatureAById(id: Int): LocalFeatureA?

    @Query("DELETE FROM feature_a WHERE id = :id")
    suspend fun deleteFeatureAById(id: Int)
}