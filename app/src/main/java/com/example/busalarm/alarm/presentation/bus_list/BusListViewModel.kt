package com.example.busalarm.alarm.presentation.bus_list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class BusListViewModel : ViewModel() {
    private val _state = MutableStateFlow(BusListState())
    val state = _state.asStateFlow()

}