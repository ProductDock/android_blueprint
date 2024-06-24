package com.blueprint.featureB.screens

import kotlinx.serialization.Serializable

sealed class ScreenB() {
    @Serializable
    object ScreenB1: ScreenB()

    @Serializable
    data class ScreenB1Details(val id: Int): ScreenB()
}