package com.blueprint.featureA.data_sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.blueprint.featureA.data.local_model.FeatureAEntity

@Dao
interface FeatureADao {
    @Insert
    suspend fun insertFeatureA(featureAEntity: FeatureAEntity)

    @Update
    suspend fun updateFeatureA(featureAEntity: FeatureAEntity)

    @Query("SELECT * FROM feature_a WHERE id = :id")
    suspend fun getFeatureAById(id: Int): FeatureAEntity?

    @Query("DELETE FROM feature_a WHERE id = :id")
    suspend fun deleteFeatureAById(id: Int)
}