package com.example.busalarm.alarm.presentation.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.commandiron.wheel_picker_compose.WheelTimePicker
import com.commandiron.wheel_picker_compose.core.TimeFormat
import com.example.busalarm.alarm.domain.Alarm
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddAlarmScreenRoot(
    viewModel: AddAlarmViewModel = koinViewModel(),
    onDeleteClick: (alarmName: String) -> Unit,
    onDoneClick: (alarm: Alarm) -> Unit,
    modifier: Modifier = Modifier
    ) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    AddAlarmScreen(
        state = state,
        onAction = {
            when (it) {
                is AddAction.onDeleteClick -> onDeleteClick(it.alarmName)
                is AddAction.onDoneClick ->  {
                    viewModel.onAction(it)
                    onDoneClick(viewModel.state.value.alarm) // append alarm instance to shared viewmodel
                    println(viewModel.state.value)
                }
                else -> viewModel.onAction(it)
            }
        },
        modifier = modifier
    )
}

@Composable
fun AddAlarmScreen(
    state: AddAlarmState,
    onAction: (action: AddAction) -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
        ) {
            WheelTimePicker(
                timeFormat = TimeFormat.AM_PM,
                size = DpSize(256.dp, 172.dp),
                rowCount = 5
            ) { time ->
                onAction(AddAction.onTimeChange(time))
            }
            Card(
                modifier = modifier
                    .width(256.dp)
                    .height(IntrinsicSize.Min)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = "name",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.fillMaxWidth(0.4f)
                        )
                        TextField(
                            value = state.nameInp,
                            onValueChange = {onAction(AddAction.onNameChange(it))},
                            modifier = Modifier.weight(1f),
                            singleLine = true
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "destination",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.fillMaxWidth(0.4f)
                        )
                        TextField(
                            value = state.destinationInp,
                            onValueChange = {onAction(AddAction.onDestinationChange(it))},
                            modifier = Modifier.weight(1f),
                            singleLine = true
                        )
                    }
                    Row(
                        modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            32.dp,
                            Alignment.CenterHorizontally
                        )
                    ) {
                        Button(onClick = { onAction(AddAction.onDeleteClick(alarmName = state.nameInp)) }) {
                            Text("Delete")
                        }
                        Button(onClick = { onAction(AddAction.onDoneClick(alarmName = state.nameInp)) }) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }
}
