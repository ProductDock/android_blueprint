package com.blueprint.di

import com.blueprint.featureA.data.repository.OfflineFirstFeatureARepository
import com.blueprint.featureA.domain.FeatureARepository
import com.blueprint.featureB.data.repository.OfflineFirstFeatureBRepository
import com.blueprint.featureB.domain.FeatureBRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @[Singleton Binds]
    abstract fun bindOfflineFirstFeatureARepository(
        offlineFirstFeatureARepository: OfflineFirstFeatureARepository
    ): FeatureARepository

    @[Singleton Binds]
    abstract fun bindOfflineFirstFeatureBRepository(
        offlineFirstFeatureBRepository: OfflineFirstFeatureBRepository
    ): FeatureBRepository
}