package com.blueprint.featureA.screens

import com.blueprint.featureB.screens.ScreenB
import kotlinx.serialization.Serializable

sealed class ScreenA() {

    @Serializable
    object ScreenA1: ScreenA()
}