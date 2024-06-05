package com.blueprint.di

import android.content.Context
import androidx.room.Room
import com.blueprint.database.AppDatabase
import com.blueprint.featureA.service.FeatureALocalService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
         Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()


    @Provides
    fun provideFeatureADao(appDatabase: AppDatabase): FeatureALocalService =  appDatabase.featureADao()

}