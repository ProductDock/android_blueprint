package com.blueprint.featureB.data.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.blueprint.featureB.data.model.local.FeatureBEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FeatureBDao {
    @Insert
    suspend fun insertFeatureB(featureBEntity: FeatureBEntity)

    @Update
    suspend fun updateFeatureB(featureBEntity: FeatureBEntity)

    @Query("SELECT * FROM feature_b")
    fun getFeaturesB(): Flow<List<FeatureBEntity>>

    @Query("SELECT * FROM feature_b WHERE id = :id")
    suspend fun getFeatureById(id: Int): FeatureBEntity?

    @Query("DELETE FROM feature_b WHERE id = :id")
    suspend fun deleteFeatureById(id: Int)
}