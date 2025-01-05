package com.example.busalarm.alarm.presentation

import androidx.lifecycle.ViewModel
import com.example.busalarm.alarm.domain.Alarm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SharedViewModel : ViewModel() {
    private val _state = MutableStateFlow(SharedState())
    val state = _state.asStateFlow()

    fun onDelete(alarmName: String): Boolean {
        val temp = _state.value.alarms.toMutableList()
        val ret = temp.removeIf { it.name == alarmName }
        if (ret) {
            _state.update {
                it.copy(
                    alarms = temp
                )
            }
        }
        return ret
    }

    fun onSave(alarm: Alarm, isNew: Boolean) {
        if (isNew) {
            _state.update {
                it.copy(
                    alarms = it.alarms + alarm
                )
            }
        } else {
            _state.update { state ->
                state.copy(
                    alarms = state.alarms.map { if (it.name == alarm.name) alarm else it }
                )

            }
        }
    }

    fun getAlarm(alarmName: String): Alarm? {
        return state.value.alarms.find { it.name == alarmName }
    }
}