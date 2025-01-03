package com.example.busalarm.alarm.presentation.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.commandiron.wheel_picker_compose.WheelTimePicker
import com.commandiron.wheel_picker_compose.core.TimeFormat

@Composable
fun AddAlarmScreenRoot(
    viewModel: AddAlarmViewModel,

) {

}

@Composable
fun AddAlermScreen(
    viewModel: AddAlarmViewModel,
    modifier: Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
        ) {
            WheelTimePicker(
                timeFormat = TimeFormat.AM_PM,
                size = DpSize(256.dp, 172.dp),
                rowCount = 5
            ) {

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
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(
                        modifier = Modifier

                    ) {
                        Text(
                            text = "name",
                            style = MaterialTheme.typography.titleMedium
                        )
                        TextField(
                            value = state.nameInp,
                            onValueChange =  {

                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}