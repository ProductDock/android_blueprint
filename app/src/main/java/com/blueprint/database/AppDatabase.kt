package com.blueprint.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.blueprint.featureA.data.model.local.FeatureAEntity
import com.blueprint.featureA.data.sources.local.FeatureADao
import com.blueprint.featureB.data.model.local.FeatureBEntity
import com.blueprint.featureB.data.sources.local.FeatureBDao

@Database(entities = [FeatureAEntity::class,
                        FeatureBEntity::class],
                        version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun featureADao(): FeatureADao
    abstract fun featureBDao(): FeatureBDao
}