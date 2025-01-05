package com.example.busalarm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SettingState(val radius: Int = 500)

sealed interface SettingAction {
    data class RadiusChanged(val radius: Int?) : SettingAction
}

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(SettingState())
    val state = _state.asStateFlow()

    fun onAction(action: SettingAction) {
        when (action) {
            is SettingAction.RadiusChanged -> {
                _state.value = _state.value.copy(radius = action.radius ?: 0 )
            }
        }
    }
}