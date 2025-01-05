package com.example.busalarm.alarm.presentation.add

import androidx.lifecycle.ViewModel
import com.example.busalarm.alarm.domain.Alarm
import com.example.busalarm.alarm.presentation.SharedViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddAlarmViewModel : ViewModel() {
    private val _state = MutableStateFlow(AddAlarmState())
    val state = _state.asStateFlow()

    fun initState(alarmId: String, sharedViewModel: SharedViewModel) {
        val alarm = sharedViewModel.getAlarm(alarmId) ?: return
        _state.update {
            it.copy(
                nameInp = alarm.name,
                timeInp = alarm.time,
                destinationInp = alarm.destination,
                alarm = alarm,
                isNew = false
            )
        }
    }

    fun onAction(action: AddAction) {
        when (action) {
            is AddAction.onDeleteClick -> {

            }

            is AddAction.onDoneClick -> {
                _state.update {
                    it.copy(
                        alarm = Alarm(
                            name = it.nameInp,
                            time = it.timeInp,
                            destination = it.destinationInp
                        )
                    )
                }
            }

            is AddAction.onDestinationChange -> {
                _state.update {
                    it.copy(
                        destinationInp = action.destination
                    )
                }
            }

            is AddAction.onNameChange -> {
                _state.update {
                    it.copy(
                        nameInp = action.name
                    )
                }
            }

            is AddAction.onTimeChange -> {
                _state.update {
                    it.copy(
                        timeInp = action.time
                    )
                }
            }
        }
    }
}
