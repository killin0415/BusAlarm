package com.example.busalarm.alarm.presentation.bus_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.systemGestureExclusion
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.busalarm.alarm.domain.Bus

@Composable
fun BusListItem(
    bus: Bus,
    curTime: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = bus.startStation,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = bus.startTime.toString(),
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = "${bus.startTime - curTime} min",
                    style = MaterialTheme.typography.titleSmall
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = bus.id.toString(),
                    style = MaterialTheme.typography.titleMedium
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                    contentDescription = null,
                )
                Text(
                    text = bus.duration.toString(),
                    style = MaterialTheme.typography.titleSmall
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = bus.endStation,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = (bus.startTime + bus.duration).toString(),
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = "${bus.desTime - bus.startTime - bus.duration} min",
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }

    }
}

@Preview
@Composable
fun BusListItemPreview() {
    val bus = Bus(
        id = 88,
        startStation = "Ping Tong",
        startTime = 1260,
        endStation = "Yen Long",
        duration = 120,
        desTime = 1400
    )
    BusListItem(
        bus,
        curTime = 1230
    )
}