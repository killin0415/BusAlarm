package com.example.busalarm.di

import com.example.busalarm.MainViewModel
import com.example.busalarm.alarm.presentation.SharedViewModel
import com.example.busalarm.alarm.presentation.add.AddAlarmViewModel
import com.example.busalarm.alarm.presentation.bus_list.BusListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val Module = module {
    viewModelOf(::SharedViewModel)
    viewModelOf(::BusListViewModel)
    viewModelOf(::AddAlarmViewModel)
    viewModelOf(::MainViewModel)
}