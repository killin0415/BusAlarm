package com.example.busalarm.alarm.presentation.bus_list

import androidx.lifecycle.ViewModel
import com.example.busalarm.alarm.domain.Alarm
import com.example.busalarm.alarm.domain.Bus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BusListViewModel : ViewModel() {
    private val _state = MutableStateFlow(BusListState())
    val state = _state.asStateFlow()

    fun update(
        alarm: Alarm
    ) {
        _state.update {
            it.copy(
                alarm = alarm,
                busList = mapOf(
                    alarm.name to listOf(
                        Bus(
                            id = 70,
                            startStation = "成大醫院(小東路)",
                            endStation = "南工宿舍",
                            startTime = 60000,
                            desTime = 61200,
                            duration = 840
                        ),
                        Bus(
                            id = 70,
                            startStation = "成大醫院(小東路)",
                            endStation = "南工宿舍",
                            startTime = 60540,
                            desTime = 61380,
                            duration = 480
                        )
                    )
                )
            )
        }
    }

}