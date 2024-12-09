package com.example.busalarm.alarm.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.busalarm.alarm.domain.Alarm
import com.example.busalarm.core.presentation.DarkBlue

@Composable
fun AlarmItem(alarm: Alarm) {
    Surface(
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        color = DarkBlue.copy(alpha = 0.2f)
    ) {
        val textModifier = Modifier.fillMaxWidth()
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                alarm.name,
                style = MaterialTheme.typography.titleMedium,
                fontFamily = FontFamily.SansSerif,
                modifier = textModifier
                    .padding(start = 16.dp)
            )
            Text(
                alarm.time,
                style = MaterialTheme.typography.headlineLarge,
                fontFamily = FontFamily.SansSerif,
                modifier = textModifier
            )
            Text(
                text = "Destination: ${alarm.destination}",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = textModifier
            )
            Text(
                text = "${alarm.timeToDestination} left",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = textModifier
            )
        }
    }
}
