package com.blueprint.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.blueprint.featureA.data.model.local.FeatureAEntity
import com.blueprint.featureA.data.sources.local.FeatureADao

@Database(entities = [FeatureAEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun featureADao(): FeatureADao
}