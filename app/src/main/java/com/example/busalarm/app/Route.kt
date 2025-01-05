package com.example.busalarm.app

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data class Add(val alarmId: String? = null) : Route

    @Serializable
    data class Alarm(val alarmId: String) : Route

    @Serializable
    data object NavGraph: Route

    @Serializable
    data object Setting: Route
}