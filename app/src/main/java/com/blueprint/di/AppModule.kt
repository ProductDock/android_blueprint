package com.blueprint.di

import android.app.Application
import android.content.Context
import com.blueprint.featureA.mapper.DefaultFeatureARemoteRemoteMapper
import com.blueprint.featureA.mapper.FeatureARemoteMapper
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
    fun provideSpaceMapper(): FeatureARemoteMapper = DefaultFeatureARemoteRemoteMapper()

}