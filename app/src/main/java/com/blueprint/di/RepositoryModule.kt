package com.blueprint.di

import com.blueprint.featureA.data.repository.DefaultFeatureARemoteRepository
import com.blueprint.featureA.data.repository.FeatureARemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @[Singleton Binds]
    abstract fun bindFeatureARepository(defaultFeatureARepository: DefaultFeatureARemoteRepository): FeatureARemoteRepository

}