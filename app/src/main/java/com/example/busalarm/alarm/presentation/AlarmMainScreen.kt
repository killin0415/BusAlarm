package com.example.busalarm.alarm.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.busalarm.alarm.domain.Alarm
import com.example.busalarm.alarm.presentation.components.AlarmList
import org.koin.androidx.compose.koinViewModel

@Composable
fun AlarmListScreenRoot(
    viewModel: SharedViewModel = koinViewModel(),
    onAlarmClick: (alarm: Alarm) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    AlarmMainScreen(
        state = state,
        onClick = { onAlarmClick(it) }
    )
}

@Composable
private fun AlarmMainScreen(
    state: SharedState,
    onClick: (alarm: Alarm) -> Unit
) {
    val scrollState = rememberLazyListState()
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        AlarmList(
            alarms = state.alarms,
            onAlarmClick = { onClick(it) },
            modifier = Modifier.fillMaxSize(),
            scrollState = scrollState
        )
    }
}