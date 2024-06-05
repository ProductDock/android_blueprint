package com.blueprint.featureA.data.local_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feature_a")
data class LocalFeatureA(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val string: String,
)
