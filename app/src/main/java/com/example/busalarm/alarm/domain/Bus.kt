package com.example.busalarm.alarm.domain

data class Bus(
    val id: Int,
    val startStation: String,
    val endStation: String,
    val startTime: Long,
    val endTime: Long,
)
