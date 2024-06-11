package com.blueprint.featureA.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feature_a")
data class FeatureAEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val string: String,
)
