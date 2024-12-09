package com.example.busalarm.alarm.domain

data class Alarm(
    val name: String,
    val time: String,
    val destination: String,
    val timeToDestination: String,
)
