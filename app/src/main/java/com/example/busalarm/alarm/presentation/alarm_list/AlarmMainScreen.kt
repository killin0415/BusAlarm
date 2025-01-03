package com.example.busalarm.alarm.presentation.alarm_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.busalarm.alarm.domain.Alarm
import com.example.busalarm.alarm.presentation.add.AddAlarmViewModel
import com.example.busalarm.alarm.presentation.components.AlarmItem
import com.example.busalarm.core.presentation.DarkBlue
import com.example.busalarm.core.presentation.DesertWhite
import org.koin.androidx.compose.koinViewModel

@Composable
fun AlarmListScreenRoot(
    viewModel: AlarmListViewModel = koinViewModel(),
    onAlarmClick: (alarm: Alarm) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    AlarmMainScreen(
        state = state,
        onAction = { action ->
            when(action) {
                is AlarmListAction.onAlarmClick -> onAlarmClick(action.alarm)
                else  -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
private fun AlarmMainScreen(
    state: AlarmListState,
    onAction: (AlarmListAction) -> Unit
) {
    Box(
        modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
    ) {
        LazyColumn (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.alarms) { item ->
                AlarmItem(item) {

                }
            }

        }

        IconButton(
            onClick = {},
            colors = IconButtonColors(
                containerColor = DarkBlue.copy(0.8f),
                contentColor = DesertWhite,
                disabledContainerColor = DarkBlue.copy(0.8f),
                disabledContentColor = DesertWhite
            ),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp)
                .size(64.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Alarm",
            )
        }
    }
}