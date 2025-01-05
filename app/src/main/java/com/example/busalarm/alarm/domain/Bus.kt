package com.example.busalarm.alarm.domain

data class Bus(
    val id: Int, // bus id
    val startStation: String,
    val endStation: String,
    val startTime: Int,
    val duration: Int,
    val desTime: Int
)
