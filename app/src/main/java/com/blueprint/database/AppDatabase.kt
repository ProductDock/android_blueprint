package com.blueprint.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.blueprint.featureA.data.local_model.LocalFeatureA
import com.blueprint.featureA.service.FeatureALocalService

@Database(entities = [LocalFeatureA::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun featureADao(): FeatureALocalService
}