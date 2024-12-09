package com.example.busalarm.app

import kotlinx.serialization.Serializable

sealed interface Route {
    data object Home: Route
    data object Settings: Route
}