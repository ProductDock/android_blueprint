package com.blueprint.featureB.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "feature_b")
data class FeatureBEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val feature: String
)