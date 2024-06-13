package com.blueprint.di

import com.blueprint.featureA.data.repository.OfflineFirstFeatureARepository
import com.blueprint.featureA.domain.FeatureARepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @[Singleton Binds]
    abstract fun bindOfflineFirstFeatureARepository(offlineFirstFeatureARepository: OfflineFirstFeatureARepository): FeatureARepository
}