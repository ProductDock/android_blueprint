package com.blueprint.featureA.mapper

import com.blueprint.featureA.data.model.local.FeatureAEntity
import com.blueprint.featureA.domain.model.FeatureA


fun FeatureA.toEntity(): FeatureAEntity = FeatureAEntity(
  string = this.string
)

fun FeatureAEntity.toDomain(): FeatureA = FeatureA(
  string = this.string
)

fun List<FeatureA>.toEntity(): List<FeatureAEntity> = map { it.toEntity() }

fun List<FeatureAEntity>.toDomain(): List<FeatureA> = map { it.toDomain() }
