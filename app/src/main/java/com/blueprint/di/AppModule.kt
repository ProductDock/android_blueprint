package com.blueprint.di

import android.app.Application
import android.content.Context
import com.blueprint.featureA.mapper.DefaultFeatureALocalMapper
import com.blueprint.featureA.mapper.DefaultFeatureARemoteMapper
import com.blueprint.featureA.mapper.FeatureALocalMapper
import com.blueprint.featureA.mapper.FeatureARemoteMapper
import com.blueprint.featureB.mapper.DefaultFeatureBLocalMapper
import com.blueprint.featureB.mapper.FeatureBLocalMapper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @[Provides Singleton]
    fun provideAppContext(application: Application): Context = application.applicationContext

    @[Provides Singleton]
    fun provideGson(): Gson = GsonBuilder().create()

    @[Provides Singleton]
    fun provideRemoteMapper(): FeatureARemoteMapper = DefaultFeatureARemoteMapper()
    @[Provides Singleton]
    fun provideLocalMapper(): FeatureALocalMapper = DefaultFeatureALocalMapper()

//    @[Provides Singleton]
//    fun provideBRemoteMapper(): FeatureBRemoteMapper = DefaultFeatureBRemoteMapper()
    @[Provides Singleton]
    fun provideBLocalMapper(): FeatureBLocalMapper = DefaultFeatureBLocalMapper()

}