package com.example.busalarm.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.busalarm.MainViewModel
import com.example.busalarm.SettingAction
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingScreen(
    viewModel: MainViewModel = koinViewModel(),
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier.padding(15.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ){
        val state by viewModel.state.collectAsStateWithLifecycle()
        Text(
            text = "Radius",
            style = MaterialTheme.typography.titleMedium
        )
        TextField(
            value = state.radius.toString(),
            onValueChange = {
                val value = it.toIntOrNull()
                viewModel.onAction(SettingAction.RadiusChanged(value))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}